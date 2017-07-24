package bbd_z.utils; /**
 * Created by cc on 2017/7/11.
 */


import info.bbd.utils.config.ConfigUtil;
import org.neo4j.jdbc.Connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Neo4jPool {


    // 配置项
    private static Map<String, String> map = new HashMap<String, String>();

    // 当前 连接数
    static int connectionCurrLink = 0;

    private static LinkedList<Connection> datasourcePool = new LinkedList<Connection>();

    static {
        try {
            Class.forName("org.neo4j.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    static {
            Properties args_properties = new Properties();
        try {
//            args_properties.load(new FileReader("neo4j.properties") );
            args_properties = ConfigUtil.getProps("neo4j.properties");
            Enumeration<Object> dataSourceSet = args_properties.keys();
            while (dataSourceSet.hasMoreElements()) {
                String key = (String) dataSourceSet.nextElement();
                map.put(key, args_properties.getProperty(key));
            }
        } catch (Exception e) {
        }
    }

    public Neo4jPool() {
        try {
            createConnection(0);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // 通过构造函数启动定时器以达到定时释放空闲连接目的
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    // 得到空闲连接，datasourcePool里面有几个对象就表示有几个空闲连接
                    int leisureLink = Neo4jPool.datasourcePool.size();
//                    System.out.println(leisureLink);
                    // 最小连接数
                    int connectionMinLink = Integer.parseInt(Neo4jPool.map.get("neo4j_conn_min_link"));
                    // 当空闲连接大于DataSourcePool设置的最小连接数时则关闭
                    if (leisureLink > connectionMinLink) {
                        for (int i = 0; i < leisureLink - connectionMinLink; i++) {
                            Neo4jPool.closeConnection(Neo4jPool.getConnection());
                            connectionCurrLink--;
                        }
                    } else {
//                        System.out.println("保持最小连接,将继续保持连接池");
                    }
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("设置了无效的最小连接数");
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, Long.parseLong(map.get("neo4j_conn_timer")));

    }

    // 创建连接
    private static void createConnection(int type) throws Exception {
        try {
            int link = 0;
            switch (type) {
                case 0:
                    link = Integer.parseInt(map.get("neo4j_conn_min_link"));
                    break;
                case 1:
                    // 如果当前连接+增长连接大于设定的最大连接数时，将使用最大连接数-当前连接的数量。以保持平衡
                    link = Integer.parseInt(map.get("neo4j_conn_increase_link"));
                    int maxLink = Integer.parseInt(map.get("neo4j_conn_max_link"));
                    if (link + connectionCurrLink > maxLink) {
                        link = maxLink - connectionCurrLink;
                    }
                    break;
            }
            for (int i = 0; i < link; i++) {
                datasourcePool.addLast((Connection) DriverManager.getConnection(map.get("neo4j_url"), map.get("neo4j_username"), map.get("neo4j_password")));
                connectionCurrLink++;
            }
        } catch (NumberFormatException n) {
            throw new NumberFormatException("配置连接参数有误");
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("超过最大连接数 ,无法创建更多连接");
        }
    }

    // 获得连接
    public static Connection getConnection() throws Exception {
        // 取连接加锁，防止并发取的同样的连接
        synchronized (datasourcePool) {
            if (datasourcePool.size() > 0) {
                return datasourcePool.removeFirst();
            } else if (connectionCurrLink < Integer.parseInt(map.get("neo4j_conn_max_link"))) {
                createConnection(1);
                return datasourcePool.removeFirst();
            }
        }
        return null;
    }

    /**
     * 关闭连接
     * @param con
     * @throws SQLException
     */
    public static void closeConnection(Connection con) throws SQLException {
        con.close();
    }

    // 释放连接
    public void freeConnection(Connection con) {
        datasourcePool.addLast(con);
    }

  /*  public static void main(String[] args) {
        Neo4jPool pool = new Neo4jPool();
        try {
            Connection conn = pool.getConnection();
            // Querying
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = (ResultSet) stmt.executeQuery("MATCH (n:Person) RETURN n.name");
                while (rs.next()) {
                    System.out.println(rs.getString("n.name"));
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }*/


}