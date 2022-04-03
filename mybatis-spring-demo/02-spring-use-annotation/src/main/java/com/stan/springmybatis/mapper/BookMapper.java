package com.stan.springmybatis.mapper;


import com.stan.springmybatis.pojo.BookPO;

public interface BookMapper{
    BookPO findBook(Integer id);
}