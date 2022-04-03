package com.stan.staticProxy;

/**
 * 测试
 */
public class TestClient {
    public static void main(String[] args) {
        GamePlayer zhangsan = new PlayerZhangSan();
        GamePlayer proxy = new PlayerProxy(zhangsan);
        proxy.login("name", "pwd");
        proxy.upgrade();
    }
}
