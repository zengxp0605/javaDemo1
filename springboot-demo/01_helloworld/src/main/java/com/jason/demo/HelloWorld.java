package com.jason.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/5 9:03 下午
 * @Modified By：
 */
public class HelloWorld {
    public static void main(String[] args) {
        int i = 0;
        List<String > list = new ArrayList<>();
        try {
            for (int j = 0; j < 260000; j++) {
                list.add(String.valueOf(j).intern());
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }
}
