package com.stan.func;

import com.stan.Factory;

/**
 *
 */
public class TestFuncFactory {
    public static void main(String[] args) {
        // 需要什么车，就向什么工厂要
        Factory factory = new AudiFactory();
        factory.getCar(null).run();

        factory = new BMWFactory();
        factory.getCar(null).run();
    }
}
