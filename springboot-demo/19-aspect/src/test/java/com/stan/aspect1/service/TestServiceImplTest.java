package com.stan.aspect1.service;

import com.stan.aspect1.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 2:02 下午
 * @Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestServiceImplTest {

    @Autowired
    private TestService testService;

    @Test
    public void test1() {
        testService.a();
        System.out.println("\n");
        testService.b();
        System.out.println("\n");
        testService.c();
    }
}
