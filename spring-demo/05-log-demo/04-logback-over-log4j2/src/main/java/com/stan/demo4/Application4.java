package com.stan.demo4;

import com.stan.log4j.demo.Application;
import com.stan.log4j2.demo.Application2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/12/30 下午11:31
 * @Modified By：
 */
public class Application4 {
    private static Logger logger = LoggerFactory.getLogger(Application4.class);

    public static void main(String[] args) {
        test();
        Application.test();
        Application2.test();
    }

    public static void test() {
        logger.info("--->test from `com.stan.logback.demo`: {}", System.currentTimeMillis());
    }
}
