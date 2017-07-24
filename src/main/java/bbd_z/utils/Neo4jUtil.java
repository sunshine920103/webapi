package bbd_z.utils; /**
 * Created by cc on 2017/7/11.
 */

import org.neo4j.jdbc.Connection;
import org.neo4j.jdbc.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

public class Neo4jUtil {
    private static Neo4jPool pool = null;

    public Neo4jUtil() throws Exception {

    }

    /**
     * 获得连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        if (pool == null) {
            synchronized (Neo4jPool.class) {
                if (pool == null) {
                    pool = new Neo4jPool();
                }
            }
        }
        return pool.getConnection();
    }

    // 关闭连接
    public static void freeConnection(ResultSet rs, Statement ps, Connection con) throws SQLException {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    pool.freeConnection(con);
                }
            }
        }
    }

    // 关闭连接
    public static void freeConnection(Connection con) throws SQLException {
        if (con != null) {
            pool.freeConnection(con);
        }
    }

}
