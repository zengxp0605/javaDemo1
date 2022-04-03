package com.stan.logbackover;

import com.stan.logback.demo.Application3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/12/30 下午11:52
 * @Modified By：
 */
public class ApplicationLogbackOver {
    private static Logger logger = LoggerFactory.getLogger(ApplicationLogbackOver.class);

    public static void main(String[] args) {
        test();
        Application3.test();
    }

    public static void test() {
        logger.info("ApplicationLogbackOver--->test from `com.stan.logbackover`: {}", System.currentTimeMillis());
    }
}
