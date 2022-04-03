package com.stan.strategy.service.impl;

import com.stan.strategy.service.PriceStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("commonMember")
public class CommonMember implements PriceStrategy {
    @Override
    public BigDecimal calculatePrice() {
        return new BigDecimal(80);
    }
}
