package com.stan.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/11/10 下午10:59
 * @Modified By：
 */
@SpringBootApplication
@MapperScan("com.stan.mp.generator.mapper")
public class MpApplication {
    public static void main(String[] args) {
        SpringApplication.run(MpApplication.class, args);
    }
}
