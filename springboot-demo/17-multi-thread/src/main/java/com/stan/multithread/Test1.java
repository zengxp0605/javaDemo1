package com.stan.multithread;

import java.util.concurrent.TimeUnit;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/7/24 4:18 下午
 * @Modified By：
 */
public class Test1 {

    public static void main(String[] args) {
        Thread thread0 = new Thread(() -> {
            enjoyMusic();
        });
        thread0.start();

        browseNews();
    }

    private static void browseNews() {
        while (true) {
            System.out.println("browseNews...");
            sleep(1);
        }
    }

    private static void enjoyMusic() {
        while (true) {
            System.out.println("enjoyMusic...");
            sleep(1);
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
