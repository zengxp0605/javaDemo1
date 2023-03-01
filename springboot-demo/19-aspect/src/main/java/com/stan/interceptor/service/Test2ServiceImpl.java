package com.stan.interceptor.service;

import com.stan.interceptor.annotation.HttpApi;
import com.stan.interceptor.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 1:56 下午
 * @Modified By：
 */
@Service
public class Test2ServiceImpl implements Test2Service {

    @Autowired
    private TestDao testDao;

    @Override
    public void a() {
        System.out.println("method a");
        testDao.query1();
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
