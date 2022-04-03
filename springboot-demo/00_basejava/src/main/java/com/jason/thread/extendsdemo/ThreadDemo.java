package com.jason.thread.extendsdemo;

public class ThreadDemo extends Thread{

    private Thread t;
    private String threadName;

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " +  threadName );
    }

    @Override
    public void run(){
        System.out.println("Running " +  this.threadName );
        try{
            for (int i = 4; i >=0 ; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

//    @Override
//    public void start  (){
//        System.out.println("Starting " +  threadName );
//        if(t == null){
//            t = new Thread(this, threadName);
//            t.start();
//        }
//    }
}
