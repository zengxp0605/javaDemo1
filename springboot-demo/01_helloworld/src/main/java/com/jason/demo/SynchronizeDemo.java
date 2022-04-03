package com.jason.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/10 9:25 上午
 * @Modified By：
 */
public class SynchronizeDemo implements Runnable {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizeDemo());
            thread.start();
        }

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count: " + count);
        System.out.println("atomicInteger: " + atomicInteger.get());
    }


    private static int count = 0;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
//        synchronized (SynchronizeDemo.class) {
            for (int i = 0; i < 100000; i++) {
                count++;
                atomicInteger.incrementAndGet();
            }
//        }
    }
}
