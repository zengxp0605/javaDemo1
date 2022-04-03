package com.stan.strategy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PriceStrategyContext {
    Map<String, PriceStrategy> strategyMap = new ConcurrentHashMap<>();

    @Autowired
    public PriceStrategyContext(Map<String, PriceStrategy> strategyMap) {
        System.out.println("自动装配strategyMap");
        strategyMap.forEach((key, item) -> {
            System.out.println("key: " + key );
            System.out.println("item: " + item.getClass().getName() );
        });

        this.strategyMap.clear();
        this.strategyMap.putAll(strategyMap);
    }

    public BigDecimal calculate(String memberType) {
        try {
            return this.strategyMap.get(memberType).calculatePrice();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
