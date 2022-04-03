package com.stan.simple;

import com.stan.*;

/**
 * 简单工厂模式
 * - 实际情况下，不可能一个工厂生产所有种类的汽车
 */
public class SimpleFactory implements Factory {
    public Car getCar(String type) {
        if ("Benz".equals(type)) {
            return new Benz();
        } else if("BMW".equals(type)){
            return new BMW();
        } else if("Audi".equals(type)){
            return new Audi();
        }

        System.out.println("没有这个车型");
        return null;
    }
}
