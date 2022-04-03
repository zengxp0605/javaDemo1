package com.jason.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        new LogTest().test();
    }

    public void test() {

        System.out.println(8<<1);
        System.out.println(8<<2);
        System.out.println(8<<3);

        byte b1=3,b2=4,b;
        b=(byte) (b1+b2);
//        b=3+4;

        byte c = (byte) 130;

        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(c);

        int a = 0;
        try {
             a = 1 / 0;
        } catch (Exception e) {
            logger.info("异常日志测试-{}: ", a, e);
        }
    }
}
