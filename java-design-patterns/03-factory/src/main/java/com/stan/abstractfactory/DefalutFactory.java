package com.stan.abstractfactory;

import com.stan.Car;
import com.stan.Factory;

/**
 * 默认的工厂
 */
public class DefalutFactory extends AbstractFactory {

    Factory defalutFactory = new BenzFactory();

    @Override
    Car getCar() {
        return defalutFactory.getCar(null);
    }
}
