package com.stan.waitnotify;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/7/28 11:42 上午
 * @Modified By：
 */
public class ProduceAndConsumerVersion01 {
    private int i = 1;
    private final Object LOCK = new Object();

    //生产者
    private void produce() {
        synchronized (LOCK) {
            System.out.println("P->,{}" + (i++));
        }
    }

    //消费者
    private void consume() {
        synchronized (LOCK) {
            System.out.println("C->,{}" + i);
        }
    }

    public static void main(String[] args) {
        ProduceAndConsumerVersion01 pc = new ProduceAndConsumerVersion01();
        //启动生产者线程
        new Thread("P") {
            @Override
            public void run() {
                while (true) {
                    pc.produce();
                }
            }
        }.start();
        //启动消费者线程
        new Thread("C") {
            @Override
            public void run() {
                while (true) {
                    pc.consume();
                }
            }
        }.start();
    }
}
