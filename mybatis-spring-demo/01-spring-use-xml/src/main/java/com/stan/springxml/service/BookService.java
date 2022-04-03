package com.stan.springxml.service;

import com.stan.springxml.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/31 1:48 下午
 * @Modified By：
 */
@Service("bookService")
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public void start() {
        System.out.println(111);
        System.out.println(bookMapper.findBook(1));
    }
}
