package com.stan.sendrecive;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/11 2:19 下午
 * @Modified By：
 */
public class Data {
    private String packet;

    private boolean transfer = true;

    public synchronized void send(String packet){
        while (!transfer){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        transfer = false;
        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive(){
        while (transfer){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        transfer = true;
        notifyAll();
        return packet;
    }
}
