package com.stan.aspect1.service;

import com.stan.aspect1.annotation.HttpApi;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 1:55 下午
 * @Modified By：
 */
public interface TestService {

    @HttpApi(value = "api-on-interface-a")
    void a();

    void b();

    void c();
}
