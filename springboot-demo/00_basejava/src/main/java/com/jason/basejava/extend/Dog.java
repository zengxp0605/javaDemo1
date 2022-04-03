package com.jason.basejava.extend;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/8/4 5:57 下午
 * @Modified By：
 */
public class Dog extends Animal {
    protected String name = "dog";

    Dog(){
        System.out.println("Dog construct");
    }

//    public void show(){
//        System.out.println("show: " + name);
//    }

//    public String getName(){
//        return name;
//    }

    protected void finalize(){
        System.out.println("Dog finalize");
    }
}
