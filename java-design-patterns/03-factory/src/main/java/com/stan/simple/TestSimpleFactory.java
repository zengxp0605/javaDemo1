package com.stan.simple;

import com.stan.Car;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/4/6 2:41 下午
 * @Modified By：
 */
public class TestSimpleFactory {
    public static void main(String[] args) {
        Car car = new SimpleFactory().getCar("Benz");
        car.run();

        car = new SimpleFactory().getCar("Audi");
        car.run();
    }
}
