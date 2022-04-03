package com.stan.strategybase;

/**
 * 测试
 */
public class Test {
    public static void main(String[] args) {

        StrategyContext context = new StrategyContext(new ConcreteStrategyAdd());
        System.out.println("add result: " +  context.calculate(1,2));

        context.changeStrategy(new ConcreteStrategySubtract());
        System.out.println("subtract result: " +  context.calculate(1,2));
    }
}
