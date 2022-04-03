package com.stan.strategybase;

/**
 * 策略上下文，包装类
 */
public class StrategyContext implements Strategy {

    private Strategy strategy;

    StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    // 切换策略
    public void changeStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public int calculate(int a, int b) {
        return this.strategy.calculate(a, b);
    }
}
