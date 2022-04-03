package com.jason.thread.counter;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * 线程不安全的计算器测试
 *
 */
public class NoSafetyCounter {

        private static ArrayList<Integer> timeList = new ArrayList<>();

    public static void main(String[] args) {
//        test();

        // 测试10次
        for (int i = 0; i < 10; i++) {
            test();
        }

        int total = 0;
        for(int t: timeList){
            total += t;
        }

        int avgTime = total / timeList.size();
        System.out.println("平均耗时: " + avgTime + " ms.");
    }

    public static void test(){
        long stime = System.currentTimeMillis();
        Counter counter = new Counter();

        int threadCount = 1000;

        // 用来让主线程等待threadCount个子线程执行完毕
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);


        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new MyThread(counter, countDownLatch));
            thread.start();
        }

        try {
            // 主线程等待所有子线程执行完成，再向下执行
            countDownLatch.await();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        long etime = System.currentTimeMillis();
        int costTime = (int) (etime - stime);
        timeList.add(costTime);
        System.out.println("耗时: " + costTime + " ms, End count: " + counter.getCount());
    }
}

class MyThread implements Runnable {
    private Counter counter;

    private CountDownLatch countDownLatch;

    public MyThread(Counter counter, CountDownLatch countDownLatch) {
        this.counter = counter;
        this.countDownLatch = countDownLatch;
    }

    public void run(){

        // 每个线程向Counter 中进行10000 次累加
        for (int i = 0; i < 10000; i++) {
            // 线程不安全的累加
//            counter.addCount();
            // 线程安全的累加
            counter.safeAddCount();
        }

        // 完成一个子线程
        countDownLatch.countDown();
    }
}


class Counter {
    private int count =0;

    // 线程不安全的累加
    public void addCount(){
        this.count ++;
    }

    // 线程安全的累加
    public synchronized void safeAddCount(){
        this.count ++;
    }

    public int getCount() {
        return count;
    }
}
