package com.stan.delegete;

/**
 * 测试启动类
 */
public class Boss {
    public static void main(String[] args) {
        System.out.println("Boss start");
        String command = "encrypt";
        new Leader().dispatch(command);

        command = "sell";
        new Leader().dispatch(command);
    }
}
