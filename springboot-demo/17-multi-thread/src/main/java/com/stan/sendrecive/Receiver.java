package com.stan.sendrecive;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/11 2:26 下午
 * @Modified By：
 */
public class Receiver implements Runnable {
    private Data load;

    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        for (String receivedMessage = load.receive();
             !"End".equals(receivedMessage);
             receivedMessage = load.receive()
        ) {

            System.out.println(receivedMessage);

            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
