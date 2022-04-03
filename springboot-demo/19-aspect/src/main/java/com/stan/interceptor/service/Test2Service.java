package com.stan.interceptor.service;

import com.stan.interceptor.annotation.HttpApi;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 1:55 下午
 * @Modified By：
 */
public interface Test2Service {

    @HttpApi(value = "api-on-interface-a")
    void a();

    void b();

    void c();
}
