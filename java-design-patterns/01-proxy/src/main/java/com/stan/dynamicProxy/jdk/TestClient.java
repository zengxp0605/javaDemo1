package com.stan.dynamicProxy.jdk;


/**
 * 测试
 */
public class TestClient {
    public static void main(String[] args) {
        Person xiaoWang = new XiaoWang();
        Person proxy = (Person)  new Matchmaker().getInstance(xiaoWang);
        proxy.findLover();
    }
}
