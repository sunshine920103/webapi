package bbd_z.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by cc on 2017/7/17.
 */
public class JsonTools {
    public static HashMap<String,HashSet<String>> Json2HashMap(String jsonText) {
        System.out.println(jsonText);

        HashMap<String,HashSet<String>> result=new HashMap<>();
        HashSet<String> nodes=new HashSet<>();
        HashSet<String> relations=new HashSet<>();
        JSONObject object = new JSONObject(jsonText);
        for(Object obj:object.getJSONObject("data").getJSONArray("path")){

            JSONArray array=(JSONArray) obj;
            int i=0;
            for(Object ob:array){
                if(i%2==0){
                    nodes.add(ob.toString());
                }
                if(i%2==1){
                    relations.add(ob.toString());
                }
                i++;
            }
        }
        result.put("nodes",nodes);
        result.put("relations",relations);
        return result;
    }

}
