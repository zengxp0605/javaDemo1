package com.jason.groovytst;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jason.groovytst.mapper")
public class GroovyTstApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroovyTstApplication.class, args);
    }

}
