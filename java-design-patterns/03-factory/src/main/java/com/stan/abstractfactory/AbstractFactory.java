package com.stan.abstractfactory;

import com.stan.*;

/**
 * 抽象工厂模式
 */
public abstract class AbstractFactory implements Factory {

    abstract Car getCar();

    public Car getCar(String type) {
        if ("Benz".equals(type)) {
            return new BenzFactory().getCar(null);
        } else if("BMW".equals(type)){
            return new BMWFactory().getCar(null);
        } else if("Audi".equals(type)){
            return new AudiFactory().getCar(null);
        }

        System.out.println("没有这个车型");
        return null;
    }
}
