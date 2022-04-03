package com.jason.demo;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/11 11:08 上午
 * @Modified By：
 */
public class SynchronizeDemo2 {
    public static void main(String[] args) {
        Object lock = new Object();
        synchronized (lock) {
            System.out.println("First time acquiring it");

            synchronized (lock) {
                System.out.println("Entering again");

                synchronized (lock) {
                    System.out.println("And again");
                }
            }
        }
    }

}
