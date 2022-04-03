package com.stan.sendrecive;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/11 2:24 下午
 * @Modified By：
 */
public class Sender implements Runnable {

    private Data data;

    String packets[] = {
            "First packet",
            "Second packet",
            "Third packet",
            "Fourth packet",
            "End"
    };

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (String packet : packets) {
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
