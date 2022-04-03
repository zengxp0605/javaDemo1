package com.stan.springxml.mapper;

import com.stan.springxml.pojo.BookPO;

public interface BookMapper{
    BookPO findBook(Integer id);
}