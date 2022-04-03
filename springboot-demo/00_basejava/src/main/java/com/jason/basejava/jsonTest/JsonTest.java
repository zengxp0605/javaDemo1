package com.jason.basejava.jsonTest;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarOutputStream;

public class JsonTest {

    @Autowired
    private  ObjectMapper mapper;

    public static String BuildPerson() {
        // JSON格式数据解析对象
//        JSONObject jo = new JSONObject();

        // 下面构造两个map、一个list和一个Employee对象
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("name", "Alexia");
        map1.put("sex", "female");
        map1.put("age", "23");

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "Edward");
        map2.put("sex", "male");
        map2.put("age", "24");

        List<Map> list = new ArrayList<Map>();
        list.add(map1);
        list.add(map2);
//
//        // 将Map转换为JSONArray数据
//        JSONArray ja1 = JSONArray.fromObject(map1);
//        // 将List转换为JSONArray数据
//        JSONArray ja2 = JSONArray.fromObject(list);
//        System.out.println("JSONArray对象数据格式：");
//        System.out.println(ja1.toString());
//        System.out.println(ja2.toString());
//
//        // 构造Json数据，包括一个map和一个Employee对象
//        jo.put("map", ja1);
//        jo.put("employee", ja2);
//        System.out.println("\n最终构造的JSON数据格式：");
//        System.out.println(jo.toString());

        return map2.toString();
    }

    public String test2() throws Exception{
        String json = "{\"name\":\"lijz\",\"id\":10}";
        JsonNode node = mapper.readTree(json);
        String name = node.get("name").asText();
        int id = node.get("id").asInt();
        String res = "name: " + name + " ,id: " + id;
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
      String str = BuildPerson();
      System.out.println(str);

      try {
         new JsonTest().test2();
      } catch (Exception e){
          e.printStackTrace();
      }
    }
}
