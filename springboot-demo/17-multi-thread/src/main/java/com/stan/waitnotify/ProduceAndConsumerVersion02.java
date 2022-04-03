package com.stan.waitnotify;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/7/28 11:42 上午
 * @Modified By：
 */
public class ProduceAndConsumerVersion02 {
    private int i = 1;
    private final Object LOCK = new Object();

    //引入一个标记，表示是否生产了数据
    private volatile boolean isProduced = true;

    //生产者
    private void produce() {
        synchronized (LOCK) {
            if (isProduced) {
                // 如果存在数据，则阻塞
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {//如果不存在数据，则需要生产数据
                i++;
                System.out.println("P-> " + i);
                LOCK.notify();
                isProduced = true;
            }
        }
    }

    //消费者
    private void consume() {
        synchronized (LOCK) {
            if (isProduced) {
                // 存在数据，则消费
                System.out.println("C->,{}" + i);
                isProduced = false;
                LOCK.notify();
            } else {
                // 不存在数据，则阻塞
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void aa() {
        System.out.println("aa");
    }

    public static void main(String[] args) {
        ProduceAndConsumerVersion02 pc = new ProduceAndConsumerVersion02();
        ProduceAndConsumerVersion02.aa();

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
