package com.stan.dynamicCglib;


/**
 * 测试
 */
public class TestClient {
    public static void main(String[] args) {
        XiaoMing obj = (XiaoMing) new CglibMatchmaker().getInstance(XiaoMing.class);
        obj.findLover();
    }
}
