package com.stan.springxml;


import com.stan.springxml.mapper.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/22 12:31 下午
 * @Modified By：
 */

public class ApplicationXml {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationXml.class);

    public static void main(String[] args) throws Exception {
        // 加载spring配置
        ApplicationContext context = new ClassPathXmlApplicationContext("server.xml");
        logger.info("Spring start...");

        BookMapper bookMapper = context.getBean(BookMapper.class);
        System.out.println(bookMapper.findBook(1));
//
//        BookService bookService = context.getBean(BookService.class);
//        bookService.start();
    }

}
