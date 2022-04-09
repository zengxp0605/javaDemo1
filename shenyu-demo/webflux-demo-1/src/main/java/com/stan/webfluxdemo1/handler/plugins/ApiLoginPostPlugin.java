package com.stan.webfluxdemo1.handler.plugins;

import com.stan.webfluxdemo1.handler.ShenyuPlugin;
import com.stan.webfluxdemo1.handler.ShenyuPluginChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @Author: zengxp
 * @Date: 2022/1/6 20:23
 * @Desc: api调用登录接口成功后，写入 session
 */
@Slf4j
public class ApiLoginPostPlugin implements ShenyuPlugin {

    private static final String pluginName = ApiLoginPostPlugin.class.getSimpleName();

    @Override
    public Mono<Void> execute(ServerWebExchange exchange, ShenyuPluginChain chain) {
        log.info("----------------{} start ------------------", pluginName);

        ServerHttpResponse response = exchange.getResponse();
        System.out.println(response);
        log.info("----------------{} end ------------------", pluginName);
        return chain.execute(exchange);
    }

    /**
     * 在Dubbo invoke 之后调用， session设置userId
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 100;
    }

    @Override
    public String named() {
        return pluginName;
    }
}
