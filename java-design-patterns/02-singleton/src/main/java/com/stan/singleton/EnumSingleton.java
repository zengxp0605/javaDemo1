package com.stan.singleton;

/**
 * 枚举
 */
public enum EnumSingleton {
    INSTANCE;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public void foo(){
        System.out.println("枚举单例，foo");
    }

}
