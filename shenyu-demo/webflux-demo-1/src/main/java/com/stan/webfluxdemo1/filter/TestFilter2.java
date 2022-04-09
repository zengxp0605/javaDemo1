package com.stan.webfluxdemo1.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @Author: zengxp
 * @Date: 2022/1/7 10:22
 * @Desc:
 */
@Slf4j
@Component
@Order(2)
public class TestFilter2 implements WebFilter {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        log.info("--------->entry TestFilter2");
        return Mono.defer(() -> {
            log.info("--------->defer TestFilter2 , threadLocal value={}", threadLocal.get());
            return chain.filter(exchange);
        });
    }
}
