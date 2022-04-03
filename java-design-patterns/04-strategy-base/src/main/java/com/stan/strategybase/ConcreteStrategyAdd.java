package com.stan.strategybase;

/**
 * 策略A
 */
public class ConcreteStrategyAdd implements Strategy {
    public int calculate(int a, int b) {
        return a + b;
    }
}
