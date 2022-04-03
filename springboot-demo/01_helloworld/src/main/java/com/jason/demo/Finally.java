package com.jason.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/10 9:08 上午
 * @Modified By：
 */
public class Finally {
    public static void main(String[] args) {
        int x = test();
        System.out.println("count:" + x);

        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            try {
                System.out.println("业务逻辑");
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int test() {
        int i = 0;
        try {
            i = 10 / 0;
        } catch (Exception e) {
            i = 20;
        } finally {
            System.out.println(i);
        }
        return i;
    }
}
