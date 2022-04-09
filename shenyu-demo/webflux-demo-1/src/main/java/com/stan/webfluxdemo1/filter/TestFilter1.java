package com.stan.webfluxdemo1.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
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
@Order(1)
public class TestFilter1 implements WebFilter {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        log.info("--------->entry TestFilter1");
        threadLocal.set(123);
        return Mono.defer(() -> {
            log.info("--------->defer TestFilter1");
            return chain.filter(exchange);
        });

        // delay 开启异步线程
//        return Mono.delay(Duration.ofSeconds(3)).then(
//                Mono.defer(() -> {
//                    log.info("--------->defer TestFilter1");
//                    return chain.filter(exchange);
//                })
//        );
    }
}
