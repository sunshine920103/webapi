package bbd_z.utils;

import org.neo4j.jdbc.Connection;
import org.neo4j.jdbc.ResultSet;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/10.
 */
public class BasicOperation {
    private static String[] match={"","-[d]-(e)","-[f]-(g)","-[h]-(i)","-[g]-(k)","-[l]-(m)","-[n]-(o)","-[p]-(q)","-[r]-(s)","-[t]-(u)"};
    private static String[] where={" and type(b)="," and type(d)="," and type(f)="," and type(h)="," and type(g)="," and type(l)="," and type(n)="," and type(p)="," and type(r)="," and type(t)="};
    private static String[] ret={"",",d,e",",f,g",",h,i",",g,k",",l,m",",n,o",",p,q",",r,s",",t,u"};

    /**
     * 获取两个点之间所有最短路径
     * @param propType
     * @param propValueOne
     * @param propValueTwo
     * @param maxLines
     * @param con
     * @return
     */
    public static HashSet<String> getShortestPath(String propType,String propValueOne,String propValueTwo,int maxLines,Connection con){
        HashSet<String> result=new HashSet<>();
        StringBuffer matchSQL = new StringBuffer();
        matchSQL.append(String.format("match (a),(b) where a.%s=\"%s\" and b.%s=\"%s\" match p=allShortestPaths((a)-[*..%s]-(b)) return p",propType,propValueOne,propType,propValueTwo,maxLines));
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(matchSQL.toString());
            ResultSet rs= (ResultSet) stmt.executeQuery();

            while(rs.next()){
                result.add(rs.getString("p"));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }




    /**
     * 获取两个点之间所有路径
     * @param propType
     * @param propValueOne
     * @param minLines
     * @param maxLines
     * @param propValueTwo
     * @param con
     * @return
     */
   public static HashSet<String> getAllPath(String propType,String propValueOne,String propValueTwo,int minLines,int maxLines,Connection con){
       HashSet<String> result=new HashSet<>();
       StringBuffer matchSQL = new StringBuffer();
       matchSQL.append(String.format("match s=(a)-[*%s..%s]-(b) where a.%s=\"%s\" and b.%s=\"%s\"  return s",String.valueOf(minLines),String.valueOf(maxLines),propType,propValueOne,propType,propValueTwo));
       PreparedStatement stmt;
       try {
           stmt = con.prepareStatement(matchSQL.toString());
           ResultSet rs= (ResultSet) stmt.executeQuery();

           while(rs.next()){
            result.add(rs.getString("s"));
           }
           return result;
       } catch (SQLException e) {
           e.printStackTrace();
       }

       return null;
   }
    /**
     *
     * @param propType 查询的属性名字，如"身份证"
     * @param propValue 查询的属性值，如"420645197801011234"
     * @param relationTypes 每一度关系的类型，数组格式
     * @return HashMap<String colName,ArrayList<String> nodeName>
     */
    public static HashMap<String,HashSet<String>> matchSourceID(String propType, String propValue,String relationTypes,Connection con){
        HashMap<String,HashSet<String>> result=new HashMap<>();
        HashSet<String> relations=new HashSet<>();
        HashSet<String> nodes=new HashSet<>();
        StringBuffer matchSQL = new StringBuffer();
        StringBuffer whereSQL = new StringBuffer();
        StringBuffer returnSQL = new StringBuffer();
//        System.out.println(relationTypes);
        int lenth=3;
        matchSQL.append("MATCH (a)-[b]-(c)");
        whereSQL.append(String.format(" where a.%s=\"%s\" ",propType,propValue));
        returnSQL.append(" return a,b,c");
        int i=0;
        if(relationTypes!=null) {
            String[] relationType=relationTypes.split("\\.");
            if(relationType.length>0) {
                for (String relaType : relationType) {
                    matchSQL.append(match[i]);
                    if (relaType.length() > 0) {
                        whereSQL.append(where[i] + "\"" + relaType + "\"");
                    }
                    returnSQL.append(ret[i]);
                    i++;
                }
                lenth = relationType.length * 2 + 1;
            }
        }


        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(matchSQL.toString()+whereSQL.toString()+returnSQL.toString());
            ResultSet rs= (ResultSet) stmt.executeQuery();
            int counter=1;
            while(rs.next()){
                for(int le=1;le<=lenth;le++){
                    if(le%2==1){
                        nodes.add(rs.getString(le));
                    }else{
                        relations.add(rs.getString(le));
                    }
                }
            }
            result.put("relations",relations);
            result.put("nodes",nodes);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @param propType 查询的属性名字，如"身份证"
     * @param propValue 查询的属性值，如"420645197801011234"
     * @param relationTypes 每一度关系的类型，数组格式
     * @return HashMap<String colName,ArrayList<String> nodeName>
     */
    public static HashMap<String,HashSet<String>> matchSourceID(String propType, String propValue,String startTime,String endTime,String relationTypes,Connection con){
        HashMap<String,HashSet<String>> result=new HashMap<>();
        HashSet<String> relations=new HashSet<>();
        HashSet<String> nodes=new HashSet<>();
        StringBuffer matchSQL = new StringBuffer();
        StringBuffer whereSQL = new StringBuffer();
        StringBuffer returnSQL = new StringBuffer();
//        System.out.println(relationTypes);
        int lenth=3;
        matchSQL.append("MATCH (a)-[b]-(c)");
        whereSQL.append(String.format(" where a.%s=\"%s\" and b.发生时间>\"%s\" and b.发生时间<\"%s\" ",propType,propValue,startTime,endTime));
        returnSQL.append(" return a,b,c");
        int i=0;
        if(relationTypes!=null) {
            String[] relationType=relationTypes.split("\\.");
            if(relationType.length>0) {
                for (String relaType : relationType) {
                    matchSQL.append(match[i]);
                    if (relaType.length() > 0) {
                        whereSQL.append(where[i] + "\"" + relaType + "\"");
                    }
                    returnSQL.append(ret[i]);
                    i++;
                }
                lenth=relationType.length*2+1;
            }
        }


        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(matchSQL.toString()+whereSQL.toString()+returnSQL.toString());
            ResultSet rs= (ResultSet) stmt.executeQuery();
            int counter=1;
            while(rs.next()){
                for(int le=1;le<=lenth;le++){
                    if(le%2==1){
                        nodes.add(rs.getString(le));
                    }else{
                        relations.add(rs.getString(le));
                    }
                }
            }
            result.put("relations",relations);
            result.put("nodes",nodes);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     *
     * @param propType 查询的属性名字，如"身份证"
     * @param propValue 查询的属性值，如"420645197801011234"
     * @param type 1返回SourceNodes信息，2返回TargetNodes信息
     * @return HashMap<String colName,ArrayList<String> nodeName>
     */
    public static HashMap<String,HashSet<String>> matchSourceID(String tp,String propType, String propValue, int type, Connection con){
        HashMap<String,HashSet<String>> result=new HashMap<>();
        HashSet<String> relations=new HashSet<>();
        HashSet<String> nodes=new HashSet<>();
        StringBuffer matchSQL = new StringBuffer();
        String SelfId=null;

        matchSQL.append("MATCH (e:"+tp+")-[s]->(f) ");
        String retSource="where f."+propType+"=\""+propValue+"\" return s,e,f";
        String retTarget="where e."+propType+"=\""+propValue+"\" return s,f,e";
        String nodeType;

        if(type==1){
            matchSQL.append(retSource);
        }else{
            matchSQL.append(retTarget);
        }
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(matchSQL.toString());
            ResultSet rs= (ResultSet) stmt.executeQuery();

            while(rs.next()){
                relations.add(rs.getString(1));
                nodes.add(rs.getString(2));
                if(SelfId==null){
                    SelfId=rs.getString(3);
                }
            }
            nodes.add(getOneNode(tp,propType,propValue,con));
            result.put("relations",relations);
            result.put("nodes",nodes);
            result.put(SelfId,null);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *创建新节点
     * @param type 节点类型
     *@param infoType index属性类型
     *@param infoValue index属性值
     *@param overWrite 是否覆盖已存在节点属性 0不覆盖，1覆盖
     * @param nodeProperties 非index属性列表
     */
    public static String insertNode(String type,String infoType,String infoValue,HashMap<String,String> nodeProperties,int overWrite,Connection con){
        if(!isNodeExist(type,infoType,infoValue,con)) {
            StringBuilder insertSQL = new StringBuilder();
            insertSQL.append("CREATE (u:" + type);
            int si=0;
            insertSQL.append(" {"+infoType+":\""+infoValue+"\"");
            if(!nodeProperties.isEmpty()){
                  for(Map.Entry<String,String> entry:nodeProperties.entrySet()){
                            insertSQL.append(","+entry.getKey()+":"+"\""+entry.getValue()+"\"");
                  }
                  insertSQL.append("})");
            }else {
                insertSQL.append("})");
            }
            PreparedStatement stmt;
            try {
                stmt = con.prepareStatement(insertSQL.toString());
                stmt.executeUpdate();
                return "Message:\"Success\"";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Message:\"Failed\"";
            }
        }else{
            if(overWrite==1){
                if(!nodeProperties.isEmpty()){
                    for(Map.Entry<String,String> entry:nodeProperties.entrySet()){
                        addOrUpdateProperties(type,infoType,infoValue,entry.getKey(),entry.getValue(),con);
                    }
                    return "Message:\"Update Success!\"";
                }
                return "Message:\"Properties is Empty!\"";
            }
        }
        return "Message:\"Skipped Existed Node!\"";
    }


    /**
     *
     * @param type 节点类型
     * @param infoType 查找类型
     * @param infoValue 查找值
     * @return 是否存在
     */
    public static boolean isNodeExist(String type,String infoType,String infoValue,Connection con){
        String insertSQL = "MATCH (u:"+type+") WHERE u."+infoType+"=\""+infoValue+"\" RETURN u";
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(insertSQL);
            ResultSet rs= (ResultSet) stmt.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     *
     * @param infoType 查找类型
     * @param infoValue 查找值
     * @return Node
     */
    public static String getOneNode(String type,String infoType,String infoValue,Connection con){
        String insertSQL = "MATCH (u:"+type+") WHERE u."+infoType+"=\""+infoValue+"\" RETURN u";
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(insertSQL);
            ResultSet rs= (ResultSet) stmt.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 创建关系
     * @param type1 起始节点类型
     * @param infoType1 查找起始节点条件类型
     * @param infoValue1  查找起始节点条件值
     * @param type2 终点节点类型
     * @param infoType2 查找终点节点条件类型
     * @param infoValue2 查找终点节点条件值
     * @param relationProperties 添加的关系属性
     */
    public static String insertRelationShip(String type1, String infoType1, String infoValue1, String type2, String infoType2, String infoValue2, String relationType,HashMap<String,String> relationProperties,Connection con){
        StringBuffer properties=new StringBuffer();
        int si=0;
        for(Map.Entry<String,String> entry:relationProperties.entrySet()){
            if(si==0){
                properties.append(entry.getKey()+":"+"\""+entry.getValue()+"\"");
                si++;
            }
            else{
                properties.append(","+entry.getKey()+":"+"\""+entry.getValue()+"\"");
            }
        }
        String realationSQL="MATCH (t1:"+type1+") WHERE t1."+infoType1+"=\""+infoValue1+"\"  MATCH(t2:"+type2+") WHERE t2."+infoType2+"=\""+infoValue2+"\" "
                +"CREATE (t1)-[:"+relationType+"{"+properties.toString()+"}]->(t2)";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(realationSQL);
            stmt.executeUpdate();
            return "Message:\"Succeed\"";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Message:\"Failed\"";
        }
    }

    /**
     * 增加或修改属性
     * @param type 节点类型
     * @param infoType 条件类型
     * @param infoValue 条件值
     * @param newType 新增（修改）类型
     * @param newValue 性增（修改）的值
     */
    public static String addOrUpdateProperties(String type,String infoType,String infoValue,String newType,String newValue,Connection con){
        String updateSQL = "MATCH (u:"+type+") WHERE u."+infoType+"=\""+infoValue+"\" SET u."+newType+"=\""+newValue+"\"";
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(updateSQL);
            stmt.executeQuery();
            return "Message:\"Succeeds\"";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Message:\"Failed\"";
        }
    }



    /**
     *
     * @param propType 查询的属性名字，如"身份证"
     * @param propValue 查询的属性值，如"420645197801011234"
     * @param relationTypes 第一度关系的类型，数组格式
     * @return HashMap<String colName,ArrayList<String> nodeName>
     */
    public static HashMap<String,HashSet<String>> matchMultiSourceID(String propType, String propValue,String relationTypes,Connection con){
        HashMap<String,HashSet<String>> result=new HashMap<>();
        HashSet<String> relations=new HashSet<>();
        HashSet<String> nodes=new HashSet<>();
        StringBuffer matchSQL = new StringBuffer();
        StringBuffer whereSQL = new StringBuffer();
        StringBuffer returnSQL = new StringBuffer();
//        System.out.println(relationTypes);
        int lenth=3;
        String wherei=" type(b)=";
        matchSQL.append(String.format("MATCH (a{%s:\"%s\"})-[b]-(c)",propType,propValue));
        whereSQL.append(" where ");
        returnSQL.append(" return a,b,c");
        if(relationTypes!=null) {
            int s=0;
            String[] relationType=relationTypes.split("\\.");
            if(relationType.length>0) {
                for (String relaType : relationType) {
                    if(s==0)
                        whereSQL.append(wherei + "\"" + relaType + "\" ");
                    else{
                        whereSQL.append("or " +wherei + "\"" + relaType + "\" ");
                    }
                    s++;
                }
            }
        }


        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(matchSQL.toString()+whereSQL.toString()+returnSQL.toString());
            ResultSet rs= (ResultSet) stmt.executeQuery();
            int counter=1;
            while(rs.next()){
                for(int le=1;le<=lenth;le++){
                    if(le%2==1){
                        nodes.add(rs.getString(le));
                    }else{
                        relations.add(rs.getString(le));
                    }
                }
            }
            result.put("relations",relations);
            result.put("nodes",nodes);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
