package com.stan.interceptor.service;

import com.stan.interceptor.Application;
import com.stan.interceptor.dao.TestDao;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 3:28 下午
 * @Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestServiceImplTest2 {

    @Autowired
    private Test2Service test2Service;

    @Autowired
    private TestDao testDao;

    @Test
    public void temp(){
        String str = RandomStringUtils.random(32, true, true);
        System.out.println(str);
    }

    @Test
    public void test2() {
        test2Service.a();
        System.out.println("\n");
        test2Service.b();
        System.out.println("\n");
        test2Service.c();
    }

    @Test
    public void test3(){
        testDao.query1();
    }
}