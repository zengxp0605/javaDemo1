package com.stan.user;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.stan.user", "com.stan.demotest"})
@EnableApolloConfig
@EnableFeignClients("com.stan.**.feign.**")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
