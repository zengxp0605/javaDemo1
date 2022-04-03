package com.stan.springmybatis;

import com.stan.springmybatis.mapper.BookMapper;
import com.stan.springmybatis.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/22 12:31 下午
 * @Modified By：
 */

public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
//        FileSystemXmlApplicationContext
        // 加载spring配置
        ApplicationContext context = new AnnotationConfigApplicationContext("com.stan.springmybatis");
        logger.info("Spring start...");

        BookMapper bookMapper = context.getBean(BookMapper.class);
        System.out.println(bookMapper.findBook(1));

        BookService bookService = context.getBean(BookService.class);
        bookService.start();
    }

}
