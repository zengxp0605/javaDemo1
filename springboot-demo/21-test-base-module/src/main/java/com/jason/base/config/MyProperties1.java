package com.jason.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/11/11 下午11:53
 * @Modified By：
 */
@ConfigurationProperties(prefix = "zecho")
public class MyProperties1 {
    private String address;
    private String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}