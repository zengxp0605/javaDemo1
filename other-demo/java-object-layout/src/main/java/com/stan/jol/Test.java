package com.stan.jol;


import java.util.concurrent.*;

/**
 * @author zengxp
 */
public class Test {

    private static final int corePoolSize = 3;
    private static final int maximumPoolSize = 6;
    private static final int CAPACITY = 10;

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(CAPACITY),
                Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 1; i <= 50; i++) {
            Runnable runnable = new MyRunnable("task-" + i);
            pool.execute(runnable);
        }

        // 关闭线程池
        pool.shutdown();
    }

    static class MyRunnable implements Runnable {
        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "---" + this.name + " is running.");
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
