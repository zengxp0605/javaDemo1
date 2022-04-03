package com.stan;

import com.stan.Car;

/**
 * 抽象接口
 */
public interface Factory {
    Car getCar(String type);
}
