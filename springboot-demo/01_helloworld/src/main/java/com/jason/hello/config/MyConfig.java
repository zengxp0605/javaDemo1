package com.jason.hello.config;

import com.jason.hello.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/6/9 11:44 上午
 * @Modified By：
 */

@Configuration
public class MyConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
