package com.stan.shenyundemo.alibabadubbo.server;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zengxp
 * @Date: 2021/12/16 10:34
 * @Desc:
 */
@SpringBootApplication
@EnableDubbo
public class TestAlibabaDubboApplication {
    public static void main(final String[] args) {
        SpringApplication.run(TestAlibabaDubboApplication.class, args);
    }
}
