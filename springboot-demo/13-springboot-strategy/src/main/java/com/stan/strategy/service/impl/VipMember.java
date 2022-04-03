package com.stan.strategy.service.impl;

import com.stan.strategy.service.PriceStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("vipMember")
public class VipMember implements PriceStrategy {
    @Override
    public BigDecimal calculatePrice() {
        return new BigDecimal(50);
    }
}
