package com.stan.multithread;

import java.util.stream.IntStream;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/7/24 5:27 下午
 * @Modified By：
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(() -> {
            IntStream.rangeClosed(0, 200).forEach(i -> System.out.println("thread-0-" + i));
        });

        thread0.start();
        // thread0 进程加入到 main 进程，会使得main进程进入等待，main线程 BLOCKED状态
        // 不使用 join 则 thread0和main线程交替进行
        thread0.join();
        IntStream.range(1, 200).forEach(i -> System.out.println("main-" + i));
    }
}
