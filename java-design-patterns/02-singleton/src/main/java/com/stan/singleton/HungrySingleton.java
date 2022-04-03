package com.stan.singleton;

/**
 * 饿汉模式
 */
public class HungrySingleton {
    private static HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return INSTANCE;
    }


    public void foo(){
        System.out.println("饿汉模式，foo");
    }
}
