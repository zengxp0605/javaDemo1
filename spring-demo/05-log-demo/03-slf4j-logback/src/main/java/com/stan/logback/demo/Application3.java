package com.stan.logback.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/12/30 下午11:22
 * @Modified By：
 */
public class Application3 {
    private static Logger logger = LoggerFactory.getLogger(Application3.class);

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        logger.info("Application3--->test from `com.stan.logback.demo`: {}", System.currentTimeMillis());
    }
}
