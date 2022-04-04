package com.stan.dynamicCglib;


/**
 * 被代理人, 不需要实现接口
 */
public class XiaoMing {
    public Object findLover() {
        System.out.println("===我是小王，要找个女朋友。");
        return null;
    }
}
