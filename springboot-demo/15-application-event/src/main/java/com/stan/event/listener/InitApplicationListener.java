package com.stan.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * ApplicationListener ContextRefreshedEvent 的使用实例
 */
@Component
public class InitApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("测试InitApplicationListener, onApplicationEvent触发");
        System.out.println("TODO: 初始化逻辑");
    }
}
