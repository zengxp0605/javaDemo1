package com.jason.thread.extendsdemo;


public class TestThread {

    public static void main(String args[]) {
        ThreadDemo R1 = new ThreadDemo("Thread-1");
        R1.start();

        ThreadDemo R2 = new ThreadDemo("Thread-2");
        R2.start();

        ThreadDemo R3 = R2;
        // 如果 ThreadDemo 没有重写父类start方法重复执行 start 会抛出异常
        // Exception in thread "main" java.lang.IllegalThreadStateException
        R3.start();
    }
}
