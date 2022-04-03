package com.stan.strategy.service;

import java.math.BigDecimal;

public interface PriceStrategy {
    /**
     * 通用行为
     * @return
     */
    BigDecimal calculatePrice();
}
