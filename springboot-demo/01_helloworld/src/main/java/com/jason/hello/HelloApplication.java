package com.jason.hello;

import com.jason.hello.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(HelloApplication.class, args);

        MyConfig config = ctx.getBean(MyConfig.class);
        // 判断是否为同一个对象， @Bean 单例的实现， MyConfig.person() 方法被代理
        System.out.println(config.person() == ctx.getBean("person"));
    }

}
