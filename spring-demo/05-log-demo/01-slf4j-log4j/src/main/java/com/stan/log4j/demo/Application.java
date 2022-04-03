package com.stan.log4j.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/12/30 下午10:54
 * @Modified By：
 */
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        logger.info("test from `com.stan.log4j.demo`: {}", System.currentTimeMillis());
    }
}
