package com.stan.abstractfactory;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/4/6 3:09 下午
 * @Modified By：
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        DefalutFactory factory = new DefalutFactory();
        factory.getCar().run();

        factory.getCar("BMW").run();
    }
}
