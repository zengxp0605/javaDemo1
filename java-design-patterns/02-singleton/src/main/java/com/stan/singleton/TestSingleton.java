package com.stan.singleton;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/4/6 12:21 下午
 * @Modified By：
 */
public class TestSingleton {
    public static void main(String[] args) {
        // 静态内部类
        System.out.println("========静态内部类=========");
        SubClassSingleton s1 = SubClassSingleton.getInstance();
        SubClassSingleton s2 = SubClassSingleton.getInstance();
        SubClassSingleton.getInstance().foo();
        System.out.println(s1 == s2);

        System.out.println("========静态内部类=========");
        DclSingleton d1 = DclSingleton.getInstance();
        DclSingleton d2 = DclSingleton.getInstance();
        System.out.println(d1 == d2);

        System.out.println("========饿汉模式=========");
        HungrySingleton.getInstance().foo();

        System.out.println("========枚举=========");
        EnumSingleton.getInstance().foo();
    }
}
