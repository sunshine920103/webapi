package bbd_z.controller;

import bbd_z.NeoDomain.NeoDomain;
import bbd_z.utils.BasicOperation;
import bbd_z.utils.JsonTools;
import bbd_z.utils.Neo4jUtil;
import bbd_z.utils.Pack4REST;
import info.bbd.utils.json.JsonNodeUtils;
import org.neo4j.jdbc.Connection;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by cc on 2017/7/18.
 */
@Controller
@RequestMapping("/")
public class Neo4jController {

    @RequestMapping(method = RequestMethod.GET,value = "/createNode")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object createNode(String str){
        String s[]=str.split(",");
        Connection connection= null;
        NeoDomain neoDomain = new NeoDomain();
        HashMap<String,String> res=new HashMap<>();
        if(s.length!=5){
            neoDomain.setSuccess(false);
            neoDomain.setCode(401);
            neoDomain.setData("Message:\"Wrong Parameters!\"");
            return neoDomain;
        }
        int flag=Integer.parseInt(s[3]);
        for(String ss:s[4].split("\\.")){
            String[] props=ss.split(":");
            res.put(props[0],props[1]);
        }

        try{
            try {
                connection=Neo4jUtil.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //todo
            //创建新节点，节点类型为Person，附带一个节点属性name，属性值为John，若已存在name值为John的节点则停止创建
            neoDomain.setData(JsonNodeUtils.getJsonNode(BasicOperation.insertNode(s[0],s[1],s[2],res,flag,connection)));
            return neoDomain;
        }catch (Exception e) {
            neoDomain.setSuccess(false);
            neoDomain.setCode(400);
            return neoDomain;
        }finally {
            try {
                Neo4jUtil.freeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/createRelation")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object createRelation(String str){
        String s[]=str.split(",");
        NeoDomain neoDomain = new NeoDomain();
        if(s.length!=8){
            neoDomain.setSuccess(false);
            neoDomain.setCode(401);
            neoDomain.setData(JsonNodeUtils.getJsonNode("Message:\"Wrong Parameters!\""));
            return neoDomain;
        }
        HashMap<String,String> res=new HashMap<>();
        for(String ss:s[7].split("\\.")){
            String[] props=ss.split(":");
            res.put(props[0],props[1]);
        }
        Connection connection= null;
        try{
            try {
                connection=Neo4jUtil.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //在类型为Person，name为Johnson的节点和类型为Person，name为Ian的节点之间增加新关系，关系类型为LLO，关系属性分别为Property1:nan,Property2；nv
            neoDomain.setData(BasicOperation.insertRelationShip(s[0],s[1],s[2],s[3],s[4],s[5],s[6],res,connection));
            return neoDomain;
        }catch (Exception e) {
            neoDomain.setSuccess(false);
            neoDomain.setCode(400);
            return neoDomain;
        }finally {
            try {
                Neo4jUtil.freeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/addOrUpdateNode")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object addOrUpdateNode(String str){
        Connection connection= null;
        NeoDomain neoDomain = new NeoDomain();
        String s[]=str.split(",");
        if(s.length!=5){
            neoDomain.setSuccess(false);
            neoDomain.setCode(401);
            neoDomain.setData("Message:\"Wrong Parameters!\"");
            return neoDomain;
        }
        try{
            try {
                connection=Neo4jUtil.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //todo
            neoDomain.setData(JsonNodeUtils.getJsonNode(BasicOperation.addOrUpdateProperties(s[0],s[1],s[2],s[3],s[4],connection)));
            return neoDomain;
        }catch (Exception e) {
            neoDomain.setSuccess(false);
            neoDomain.setCode(400);
            return neoDomain;
        }finally {
            try {
                Neo4jUtil.freeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/searchPaths")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object searchPaths(String str){
        Connection connection= null;
        NeoDomain neoDomain = new NeoDomain();
        String s[]=str.split(",");
        if(s.length!=5){
            neoDomain.setSuccess(false);
            neoDomain.setCode(401);
            neoDomain.setData("Message:\"Wrong Parameters!\"");
            return neoDomain;
        }
        try{
            //todo
            Pack4REST pack4REST=new Pack4REST(s[0],s[1],s[2],Integer.parseInt(s[3]),Integer.parseInt(s[4]));
            neoDomain.setData(JsonNodeUtils.getJsonNode(pack4REST.getAll(JsonTools.Json2HashMap("{\"data\":{"+pack4REST.getAllPath()+"}}"))));
            return neoDomain;
        }catch (Exception e) {
            neoDomain.setSuccess(false);
            neoDomain.setCode(400);
            return neoDomain;
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/searchShortestPaths")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object searchShortestPaths(String str){
        Connection connection= null;
        NeoDomain neoDomain = new NeoDomain();
        String s[]=str.split(",");
        if(s.length!=4){
            neoDomain.setSuccess(false);
            neoDomain.setCode(401);
            neoDomain.setData("Message:\"Wrong Parameters!\"");
            return neoDomain;
        }

        try{
            Pack4REST pack4REST=new Pack4REST(s[0],s[1],s[2],Integer.parseInt(s[3]));
            neoDomain.setData(JsonNodeUtils.getJsonNode(pack4REST.getAll(JsonTools.Json2HashMap("{\"data\":{"+pack4REST.getAllPath()+"}}"))));
            return neoDomain;
        }catch (Exception e) {
            neoDomain.setSuccess(false);
            neoDomain.setCode(400);
            return neoDomain;
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/searchSingleDimension")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object searchSingleDimension(String str){
        Connection connection= null;
        NeoDomain neoDomain = new NeoDomain();
        String s[]=str.split(",");
        if(s.length!=3){
            neoDomain.setSuccess(false);
            neoDomain.setCode(401);
            neoDomain.setData("Message:\"Wrong Parameters!\"");
            return neoDomain;
        }
        try{
            Pack4REST pack4REST=new Pack4REST();
            pack4REST.PackREST(s[0],s[1],s[2]);
            neoDomain.setData(JsonNodeUtils.getJsonNode(pack4REST.getAllJson()));
            return neoDomain;
        }catch (Exception e) {
            neoDomain.setSuccess(false);
            neoDomain.setCode(400);
            return neoDomain;
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/searchMultiDimension")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object searchMultiDimension(String str){
        Connection connection= null;
        NeoDomain neoDomain = new NeoDomain();
        String s[]=str.split(",");

        if(s.length!=3){
            neoDomain.setSuccess(false);
            neoDomain.setCode(401);
            neoDomain.setData("Message:\"Wrong Parameters!\"");
            return neoDomain;
        }
        try{

            Pack4REST pack4REST=new Pack4REST(s[0],s[1],s[2]);
            neoDomain.setData(JsonNodeUtils.getJsonNode(pack4REST.getAllSignedJson()));
            return neoDomain;
        }catch (Exception e) {
            neoDomain.setSuccess(false);
            neoDomain.setCode(400);
            return neoDomain;
        }
    }
    @RequestMapping(method = RequestMethod.GET,value = "/searchMultiDimensionIn")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object searchMultiDimensionIn(String str){
        Connection connection= null;
        NeoDomain neoDomain = new NeoDomain();
        String s[]=str.split(",");

        if(s.length!=5){
            neoDomain.setSuccess(false);
            neoDomain.setCode(401);
            neoDomain.setData("Message:\"Wrong Parameters!\"");
            return neoDomain;
        }
        try{

            Pack4REST pack4REST=new Pack4REST(s[0],s[1],s[2],s[3],s[4]);
            neoDomain.setData(JsonNodeUtils.getJsonNode(pack4REST.getAllSignedJson()));
            return neoDomain;
        }catch (Exception e) {
            neoDomain.setSuccess(false);
            neoDomain.setCode(400);
            return neoDomain;
        }
    }



    @RequestMapping(method = RequestMethod.GET,value = "/matchMultiSourceID")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object matchMultiSourceID(String str){
        Connection connection= null;
        NeoDomain neoDomain = new NeoDomain();
        String s[]=str.split(",");

        if(s.length!=3){
            neoDomain.setSuccess(false);
            neoDomain.setCode(401);
            neoDomain.setData("Message:\"Wrong Parameters!\"");
            return neoDomain;
        }
        try{

            Pack4REST pack4REST=new Pack4REST();
            pack4REST.Pack3REST(s[0],s[1],s[2]);
            neoDomain.setData(JsonNodeUtils.getJsonNode(pack4REST.getAllSignedJson()));
            return neoDomain;
        }catch (Exception e) {
            neoDomain.setSuccess(false);
            neoDomain.setCode(400);
            return neoDomain;
        }
    }
}
