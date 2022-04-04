package com.stan.dynamicProxy.custom;

import com.stan.dynamicProxy.Person;
import com.stan.dynamicProxy.jdk.XiaoWang;

/**
 * @author：zengxp
 * @date：2022/4/4 下午3:00
 */
public class TestClient {
    public static void main(String[] args) {
        Person xiaoWang = new XiaoWang();
        Person proxy = (Person) new CustomMatchmaker().getInstance(xiaoWang);
        proxy.findLover();
    }
}
