package com.stan.staticProxy;

/**
 * 真实玩家，被代理人
 */
public class PlayerZhangSan implements GamePlayer {
    public void login(String username, String password) {
        System.out.println("===我是张三，登陆游戏");
    }

    public void upgrade() {
        System.out.println("===我是张三，升级了");
    }
}
