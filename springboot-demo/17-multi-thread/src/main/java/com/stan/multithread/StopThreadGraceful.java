package com.stan.multithread;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/7/24 6:01 下午
 * @Modified By：
 */
public class StopThreadGraceful extends Thread {

    public static void main(String[] args) throws InterruptedException {
        StopThreadGraceful t0 = new StopThreadGraceful();
        t0.start();
        Thread.sleep(10000L);
        // 关闭线程
        t0.close();
    }

    //设置自己的中断标志位
    private volatile boolean isClosed = false;

    @Override
    public void run() {
        while (true) {
            System.out.println("t1 will start work");
            while (!isClosed && !isInterrupted()) {//两者都判断
                // doing work;
                System.out.println("working...");
            }
            System.out.println("t1 will exit");
            break;
        }
    }

    //供外部调用的close方法，用于执行标记中断。
    public void close() {
        this.isInterrupted();
        this.isClosed = true;
    }
}
