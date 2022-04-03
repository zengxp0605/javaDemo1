package com.stan.springxml.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/31 2:56 下午
 * @Modified By：
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:server.xml")
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void start() {
        bookService.start();
    }
}