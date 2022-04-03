package com.stan.deadlock;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/5 8:30 下午
 * @Modified By：
 */
public class Demo1 {
    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args) throws Exception {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("Get a and b");
                }
            }
        }, "thread-1").start();
        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (b) {
                synchronized (a) {
                    System.out.println("Get a and b");
                }
            }
        }, "thread-2").start();
    }
}
