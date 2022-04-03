package com.jason.demo;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/11 7:56 下午
 * @Modified By：
 */
public class Demo2 {
    volatile static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (run) { // 1s后程序不会如愿退出循环

            }
        }).start();

        Thread.sleep(1000L);
        run = false; // 1s后程序不会如愿停止
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.incrementAndGet();

        Unsafe unsafe = Unsafe.getUnsafe();
//        unsafe.compareAndSwapInt();
    }
}
