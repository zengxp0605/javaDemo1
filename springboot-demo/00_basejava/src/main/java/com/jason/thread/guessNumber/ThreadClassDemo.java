package com.jason.thread.guessNumber;

public class ThreadClassDemo {

    public static void main(String[] args) {
        Runnable hello = new DisplayMessage("Hello");
        Thread thread1 = new Thread(hello);
        thread1.setDaemon(true);
        thread1.setName("hello");
        System.out.println("Starting hello thread...");
        thread1.start();

        Runnable bye = new DisplayMessage("Goodbye");
        Thread thread2 = new Thread(bye);
//        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setDaemon(true);
        System.out.println("Starting goodbye thread...");
        thread2.start();

        System.out.println("Starting thread3...");
        Thread thread3 = new GuessNumber(27);
        thread3.setName("guess27-- ");
        thread3.start();
        try {
            /**
             * 为什么要用join()方法 ?
             *   在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，
             *   主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，
             *   也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。
             */
            thread3.join();
        }catch(InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Starting thread4...");
        Thread thread4 = new GuessNumber(75);

        thread4.start();
        System.out.println("main() is ending...");

    }
}
