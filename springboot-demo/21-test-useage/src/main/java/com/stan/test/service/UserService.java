package com.stan.test.service;


import com.jason.base.annotation.HttpApi;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 1:55 下午
 * @Modified By：
 */
public interface UserService {

    @HttpApi(value = "aop-interface-a")
    void a();

    void b();

    void c();
}
