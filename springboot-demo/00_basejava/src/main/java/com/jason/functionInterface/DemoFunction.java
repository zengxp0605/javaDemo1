package com.jason.functionInterface;

public class DemoFunction implements IDemoInterface {

    @Override
    public void print(String s) {
        System.out.println("DemoFunction print : " +s);
    }
}
