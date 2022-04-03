package com.jason.thread.counter;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAndSynchronized {

    /**
     * 并发时不能保证原子性
     */
    private int i = 0;

    private int syncCounter = 0;

    /**
     * 并发时不能保证原子性
     */
    private volatile int vltCounter = 0;

    /**
     * 可以保证原子性
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final VolatileAndSynchronized increaseTest = new VolatileAndSynchronized();
        int count = 10;
        Thread[] threads = new Thread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(() -> {
//                System.out.println(Thread.currentThread().getName());
                for (int i1 = 0; i1 < 100000; i1++) {
                    increaseTest.increase();
                    increaseTest.syncIncrease();
                    increaseTest.vltIncrease();
                    increaseTest.atomicIncrease();
                }
            });
            threads[i].start();
            // join 使得多个线程顺序执行
//            threads[i].join();
        }

        // 输出当前所有的线程
        ThreadGroup currentGroup =
                Thread.currentThread().getThreadGroup();
        int noThreads = currentGroup.activeCount();
        Thread[] lstThreads = new Thread[noThreads];
        currentGroup.enumerate(lstThreads);
        for (int i = 0; i < noThreads; i++) {
            System.out.println("线程号：" + i + " = " + lstThreads[i].getName());
        }


        increaseTest.printAllThreads();

        // 保证前面的线程都执行完
//        while (true) {
//            System.out.println(Thread.activeCount());
//            //  Main 线程 + Monitor线程
//            if (Thread.activeCount() > 2) {
//                Thread.yield();
//            } else {
//                break;
//            }
//        }

        // 等待所有的子线程结束
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(increaseTest);
    }

    public void increase() {
        i++;
    }

    /**
     * 可以保证原子性
     */
    public synchronized void syncIncrease() {
        syncCounter++;
    }

    public void vltIncrease() {
        vltCounter++;
    }

    public void atomicIncrease() {
        atomicInteger.getAndIncrement();
    }

    /**
     * 打印所有线程
     * 包含以下
     * [6]Monitor Ctrl-Break
     * [5]Attach Listener
     * [4]Signal Dispatcher
     * [3]Finalizer
     * [2]Reference Handler
     * [1]main
     */
    public void printAllThreads() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo info : threadInfos) {
            System.out.println("[" + info.getThreadId() + "]" + info.getThreadName());
        }

        System.out.println("TotalThreadCount: " + Thread.activeCount());
    }

    @Override
    public String toString() {
        return "IncreaseTest{" +
                "i=" + i +
                ", vltCounter=" + vltCounter +
                ", syncCounter=" + syncCounter +
                ", atomicInteger=" + atomicInteger +
                '}';
    }
}
