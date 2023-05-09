package com.stan.guard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.stan.user", "com.stan.demotest"})
//@EnableApolloConfig // --未配置好
@EnableFeignClients("com.stan.**.feign.**")
public class GuardApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuardApplication.class, args);
    }
}
