package com.jason.basejava.collectionTest;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        testArrayList();
        testHashMap();
    }

    public static void testHashMap() {
        System.out.println("\n============testHashMap==============");
        Map<String, Integer> map = new HashMap<>();
        map.put("test1", 111);
        map.put("test2", 222);
        map.put("3", 333);
        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ,value = " + map.get(key));
        }

        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, Integer>> ite = map.entrySet().iterator();
        while (ite.hasNext()){
            Map.Entry<String, Integer> entry = ite.next();
            System.out.println("key = " + entry.getKey() + " ,value = " + entry.getKey());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (int v : map.values()) {
            System.out.println("value= " + v);
        }
    }

    public static void testArrayList() {
        System.out.println("\n============testArrayList==============");

        List<String> list = new ArrayList<>();
        list.add("AAtest");
        list.add("BBB");
        list.add("CCC");

        System.out.println("--------1-------");
        //第一种遍历方法使用 For-Each 遍历 List
        for (String str: list){
            System.out.println(str);
        }
        System.out.println("-------2--------");

        // 或者
        for (int i =0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        System.out.println("-------3--------");
        //第二种遍历，把链表变为数组相关的内容进行遍历
        String[] strArray = new String[list.size()];
        list.toArray(strArray);
        for(int i =0; i<strArray.length; i++){
            System.out.println(strArray[i]);
        }

        System.out.println("-------4--------");
        // 第三种遍历 使用迭代器进行相关遍历
        Iterator<String> ite = list.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }

    }
}
