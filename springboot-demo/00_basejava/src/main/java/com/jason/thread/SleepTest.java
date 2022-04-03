package com.jason.thread;

import java.util.Date;

public class SleepTest {

    public static void main(String[] args) {
        for(int i =0; i< 10; i++){
            System.out.println("Now: " + new Date());
            try {
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        int total = 0;
        for(int i =0; i<=10000; i++){
            total ++;
        }
        System.out.println("End total: " + total);

    }
}
