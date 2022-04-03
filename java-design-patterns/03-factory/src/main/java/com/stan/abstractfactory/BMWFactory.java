package com.stan.abstractfactory;

import com.stan.BMW;
import com.stan.Car;
import com.stan.Factory;


public class BMWFactory implements Factory {
    public Car getCar(String type) {
        return new BMW();
    }
}
