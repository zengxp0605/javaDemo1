package com.stan.test.service;

import com.jason.base.annotation.HttpApi;
import org.springframework.stereotype.Service;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 1:56 下午
 * @Modified By：
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void a() {
        System.out.println("UserServiceImpl method a");
    }

    @Override
    @HttpApi("aop-impl-method-b")
    public void b() {
        System.out.println("UserServiceImpl method b");
    }

    @Override
    public void c() {
        System.out.println("UserServiceImpl method c");
    }
}
