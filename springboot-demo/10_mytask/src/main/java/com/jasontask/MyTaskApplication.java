package com.jasontask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 开启定时任务
@EnableScheduling
// 开启异步调用方法
@EnableAsync
public class MyTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyTaskApplication.class, args);
    }
}
