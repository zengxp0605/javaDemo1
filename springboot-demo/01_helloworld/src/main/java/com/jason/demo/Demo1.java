package com.jason.demo;

/**
 * VM options: -Xms20m -Xmx20m -XX:+PrintGC -XX:+PrintGCDetails -XX:+UseSerialGC -XX:NewRatio=1
 */
public class Demo1 {
    private final static int _1MB = 1024 * 1024;
    private final static int _2MB = _1MB * 2;
    private final static int _8MB = _1MB * 8;

    public static void main(String[] args) throws Exception {
//        System.gc();

        byte[] b1 = new byte[_2MB];
        byte[] b2 = new byte[_2MB];
        b1 = null;
//        b2 = null;
        byte[] b3 = new byte[_2MB];

        Thread.sleep(2000L);
    }
}
