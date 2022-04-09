package com.stan.webfluxdemo1.config;

import com.stan.webfluxdemo1.handler.ShenyuWebHandler;
import com.stan.webfluxdemo1.handler.ShenyuPlugin;
import com.stan.webfluxdemo1.handler.plugins.TestPlugin2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.DispatcherHandler;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zengxp
 * @Date: 2022/1/7 10:05
 * @Desc:
 */
@Slf4j
@Configuration
@EnableWebFlux
@AutoConfigureAfter(value = PluginConfig.class)
public class WebConfig {

    /**
     * 覆盖原有的 DispatcherHandler
     *
     * @return
     */
    @Bean("dispatcherHandler")
    public DispatcherHandler dispatcherHandler() {
        return new DispatcherHandler();
    }

    // 测试插件机制
//    @Bean("webHandler")
//    public ShenyuWebHandler shenyuWebHandler(final ObjectProvider<List<ShenyuPlugin>> plugins) {
//        List<ShenyuPlugin> pluginList = plugins.getIfAvailable(Collections::emptyList);
//        List<ShenyuPlugin> shenyuPlugins = pluginList.stream()
//                .sorted(Comparator.comparingInt(ShenyuPlugin::getOrder)).collect(Collectors.toList());
//        shenyuPlugins.forEach(shenyuPlugin -> log.info("load plugin:[{}] [{}]", shenyuPlugin.named(), shenyuPlugin.getClass().getName()));
//        return new ShenyuWebHandler(shenyuPlugins);
//    }

}
