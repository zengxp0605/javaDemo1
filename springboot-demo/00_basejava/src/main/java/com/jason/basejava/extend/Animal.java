package com.jason.basejava.extend;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/8/4 5:54 下午
 * @Modified By：
 */
public class Animal {
    protected String  name = "animal";

    Animal(){
        System.out.println("Animal construct");
//        this.name = "animal";
    }

    public void show(){
        System.out.println("Say from: " + getName());
    }

    public String getName(){
        return name;
    }
}
