package com.jason.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        FixedThreadPool fixedThreadPool1 = new FixedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;

            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " -->index: " + index);
                        Thread.sleep(2000);
                        fixedThreadPool1.test();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }

        System.out.println("end, 适合线程数: " + Runtime.getRuntime().availableProcessors());
    }

    private void test(){
        System.out.println("test");
    }
}
