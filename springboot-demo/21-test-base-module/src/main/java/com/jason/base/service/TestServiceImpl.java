package com.jason.base.service;

import com.jason.base.annotation.HttpApi;
import org.springframework.stereotype.Service;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 1:56 下午
 * @Modified By：
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void a() {
        System.out.println("method a");
    }

    @Override
    @HttpApi("api-on-method-b")
    public void b() {
        System.out.println("method b");
    }

    @Override
    public void c() {
        System.out.println("method c");
    }
}
