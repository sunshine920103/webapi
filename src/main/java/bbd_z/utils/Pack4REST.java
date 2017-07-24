package bbd_z.utils;

import org.neo4j.jdbc.Connection;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by cc on 2017/7/14.
 */
public class Pack4REST {
    private HashMap<String,HashSet<String>> all_source=new HashMap<>();
    private HashMap<String,HashSet<String>> all_target=new HashMap<>();
    private HashMap<String,HashSet<String>> all_signed=new HashMap<>();
    private HashSet<String> all_path=new HashSet<>();
    public Pack4REST(){

    }
    /**
     *
     * @param strType
     * @param strValueOne
     * @param strValueTwo
     * @param maxLines
     */
    public Pack4REST(String strType, String strValueOne,String strValueTwo, int maxLines) {
        Connection connection=null;
        try {
            connection = Neo4jUtil.getConnection();
            all_path = BasicOperation.getShortestPath(strType,strValueOne,strValueTwo,maxLines,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    Neo4jUtil.freeConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     *
     * @param strType
     * @param strValueOne
     * @param strValueTwo
     * @param minLines
     * @param maxLines
     */
    public Pack4REST(String strType, String strValueOne,String strValueTwo, int minLines, int maxLines) {
        Connection connection=null;
        try {
            connection = Neo4jUtil.getConnection();
            all_path = BasicOperation.getAllPath(strType,strValueOne,strValueTwo,minLines,maxLines,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    Neo4jUtil.freeConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 在构造函数中填充结果数据
     * @param strType
     * @param strValue
     */
    public Pack4REST(String strType, String strValue,String relationTypes)
    {
        Connection connection=null;
        try {
            connection = Neo4jUtil.getConnection();
            all_signed = BasicOperation.matchSourceID(strType,strValue,relationTypes,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    Neo4jUtil.freeConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 在构造函数中填充结果数据
     * @param strType
     * @param strValue
     */
    public void Pack3REST(String strType, String strValue,String relationTypes)
    {
        Connection connection=null;
        try {
            connection = Neo4jUtil.getConnection();
            all_signed = BasicOperation.matchMultiSourceID(strType,strValue,relationTypes,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    Neo4jUtil.freeConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 在构造函数中填充结果数据,增加筛选时间
     * @param strType
     * @param strValue
     */
    public Pack4REST(String strType, String strValue,String startTime,String endTime,String relationTypes)
    {
        Connection connection=null;
        try {
            connection = Neo4jUtil.getConnection();
            all_signed = BasicOperation.matchSourceID(strType,strValue,startTime,endTime,relationTypes,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    Neo4jUtil.freeConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 在构造函数中填充结果数据
     * @param strType
     * @param strValue
     */
    public void PackREST(String Nodetype,String strType, String strValue)
    {
        Connection connection=null;
        try {
            connection = Neo4jUtil.getConnection();
            all_source = BasicOperation.matchSourceID(Nodetype,strType,strValue,1,connection);
            all_target = BasicOperation.matchSourceID(Nodetype,strType,strValue,2,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    Neo4jUtil.freeConnection(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     * @return
     */
    public String getAllPath(){
        StringBuffer sb=new StringBuffer();
        sb.append("\"path\":[");
        int si=0;
        for (String str:all_path){
            if(si==0){
                sb.append(str+"");
            }else{
                sb.append(","+str+"");
            }
            si++;

        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 将拿到的Path通过Tools打包成需要的类型
     * @param alls
     * @return
     */
    public String getAll(HashMap<String,HashSet<String>> alls){
        StringBuffer nodes=new StringBuffer();
        StringBuffer relations=new StringBuffer();
        nodes.append("\"nodes\":[");
        relations.append("\"links\":[");
        int si=0;
        for(String str:alls.get("nodes")){
            if(si==0) {
                nodes.append(str);
            }else{
                nodes.append(","+str);
            }
            si++;
        }
        si=0;
        for(String str:alls.get("relations")){
            if(si==0) {
                relations.append(str);
            }else{
                relations.append(","+str);
            }
            si++;
        }
        nodes.append("]");
        relations.append("]");
        String res="{\"data\":{"+nodes.toString()+","+relations.toString()+"}}";

        return res;
    }
    /**
     *pack data
     * @return json data
     */
    public String getAllSignedJson(){
        StringBuffer nodes=new StringBuffer();
        StringBuffer relations=new StringBuffer();
        nodes.append("\"nodes\":[");
        relations.append("\"links\":[");
        int si=0;
        for(String str:all_signed.get("nodes")){
            if(si==0) {
                nodes.append(str);
            }else{
                nodes.append(","+str);
            }
            si++;
        }
        si=0;
        for(String str:all_signed.get("relations")){
            if(si==0) {
                relations.append(str);
            }else{
                relations.append(","+str);
            }
            si++;
        }
        nodes.append("]");
        relations.append("]");
        String res="{"+nodes.toString()+","+relations.toString()+"}";

        return res;
    }
    /**
     *pack data
     * @return json data
     */
    public String getAllJson(){
        StringBuffer nodes=new StringBuffer();
        StringBuffer relations=new StringBuffer();
        nodes.append("\"nodes\":[");
        relations.append("\"links\":[");
        HashSet<String> nodeSet=new HashSet<>();
        HashSet<String> relationSet=new HashSet<>();

        for(String str:all_source.get("nodes")){
            if(str==null)
                continue;
            nodeSet.add(str);
        }
        for(String str:all_source.get("relations")){
            if(str==null)
                continue;
            relationSet.add(str);
        }
        for(String str:all_target.get("nodes")){
            if(str==null)
                continue;
            nodeSet.add(str);
        }
        for(String str:all_target.get("relations")){
            if(str==null)
                continue;
            relationSet.add(str);
        }
        int a=0;int b=0;
        for(String str:nodeSet){
            if(a==0){
                nodes.append(str);
            }else{
                nodes.append(","+str);
            }
            a++;
        }
        for(String str:relationSet){
            if(b==0){
                relations.append(str);
            }else{
                relations.append(","+str);
            }
            b++;
        }
        nodes.append("]");
        relations.append("]");
        String res="{"+nodes.toString()+","+relations.toString()+"}";

        return res;
    }


}
