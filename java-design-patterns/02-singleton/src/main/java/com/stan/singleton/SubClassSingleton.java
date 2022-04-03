package com.stan.singleton;

/**
 * 单例-静态内部类
 */
public class SubClassSingleton {
    /**
     * 私有构造方法，防止外部实例化
     */
    private SubClassSingleton() {
    }

    /**
     * 内部类，外部不能访问
     */
    private static class SubHolder {
        public static final SubClassSingleton INSTANCE = new SubClassSingleton();
    }

    public static SubClassSingleton getInstance(){
        return SubHolder.INSTANCE;
    }

    public void foo(){
        System.out.println("静态内部类 foo");
    }
}
