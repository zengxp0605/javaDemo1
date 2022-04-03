package com.stan.strategybase;

/**
 * 策略B
 */
public class ConcreteStrategySubtract implements Strategy {
    public int calculate(int a, int b) {
        return a - b;
    }
}
