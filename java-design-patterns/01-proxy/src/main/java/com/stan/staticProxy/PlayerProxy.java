package com.stan.staticProxy;

/**
 * 代理人
 */
public class PlayerProxy implements GamePlayer {

    /**
     * 持有被代理对象的引用
     */
    private GamePlayer realPlayer;

    PlayerProxy(GamePlayer realPlayer) {
        this.realPlayer = realPlayer;
    }

    public void login(String username, String password) {
        System.out.println("我是代理，代玩家登陆");
        this.realPlayer.login(username, password);
    }

    public void upgrade() {
        System.out.println("我是代理，代玩家升级");
        this.realPlayer.upgrade();
        System.out.println("我是代理，玩家升级了，收取费用。");
    }
}
