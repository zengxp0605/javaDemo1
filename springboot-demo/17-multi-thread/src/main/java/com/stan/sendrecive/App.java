package com.stan.sendrecive;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/11 2:27 下午
 * @Modified By：
 */
public class App {
    public static void main(String[] args) {
        Data data = new Data();

        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}
