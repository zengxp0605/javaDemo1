package com.stan.interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 3:16 下午
 * @Modified By：
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(com.stan.aspect1.Application.class, args);
    }
}
