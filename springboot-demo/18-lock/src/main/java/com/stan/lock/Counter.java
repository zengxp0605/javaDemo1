package com.stan.lock;

import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/2/25 3:27 下午
 * @Modified By：
 */
@Component
public class Counter {

    private final Lock lock = new ReentrantLock();

    private int count = 0;

    public void add(int n) throws InterruptedException {
        synchronized (this) {
            Thread.sleep(10000);
            count += n;
        }
    }

    public void addWithLock(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }

    public int get() {
        return count;
    }
}
