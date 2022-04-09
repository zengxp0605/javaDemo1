package com.stan.webfluxdemo1.handler;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: zengxp
 * @Date: 2022/1/7 12:26
 * @Desc:
 */
public interface ShenyuPluginChain {
    Mono<Void> execute(ServerWebExchange exchange);
}
