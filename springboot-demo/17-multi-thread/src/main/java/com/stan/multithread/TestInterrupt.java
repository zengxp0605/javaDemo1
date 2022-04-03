package com.stan.multithread;

import java.util.concurrent.TimeUnit;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/7/24 5:53 下午
 * @Modified By：
 */
public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(() -> {
            while (true) {
                System.out.println("this is thread-0 : " + Thread.currentThread().isInterrupted());
            }
        });

        thread0.start();
        TimeUnit.SECONDS.sleep(5);
        thread0.interrupt();
    }
}
