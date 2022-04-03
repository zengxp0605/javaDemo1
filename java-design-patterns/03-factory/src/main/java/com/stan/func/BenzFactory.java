package com.stan.func;

import com.stan.Benz;
import com.stan.Car;
import com.stan.Factory;


public class BenzFactory implements Factory {
    public Car getCar(String type) {
       return new Benz();
    }
}
