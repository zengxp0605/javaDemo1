package com.stan.learnmybatis.mapper;

import com.stan.learnmybatis.pojo.BookPO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper{
    BookPO findBook(Integer id);

    /**
     * 测试同时使用注解和xml,优先级？ --> 报错？
     * @return
     */
    @Select("select id,author,book_name as bookName,create_time as createTime" +
            " from book limit 10;")
    List<BookPO> listBooks();

    void insertBook(BookPO bookPO);
}