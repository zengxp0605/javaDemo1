package com.stan.log4j2.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/12/30 下午11:13
 * @Modified By：
 */
public class Application2 {
    private static Logger logger = LoggerFactory.getLogger(Application2.class);

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        logger.info("test from `com.stan.log4j2.demo`: {}", System.currentTimeMillis());
    }
}
