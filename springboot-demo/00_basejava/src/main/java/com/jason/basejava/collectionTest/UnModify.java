package com.jason.basejava.collectionTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试集合不能被修改
 */
public class UnModify {

    private static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "one");
        map.put(2, "two");
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        // test modify
        CanModifyMap.main(args);

        test1();
    }

    private static void test1(){
        try {
            map.put(1, "three"); // 这里会抛出异常: Exception in thread "main" java.lang.UnsupportedOperationException
            System.out.println("[CanModifyMap]map: " + map);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}


/**
 * 可以修改用 final 修饰的 map内部的值
 */
class CanModifyMap {

    private static final Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "one");
        map.put(2, "two");
    }

    public static void main(String[] args) {
        map.put(1, "three");
        System.out.println("[CanModifyMap]map: " + map); // {1=three, 2=two}
    }
}