package com.stan.dal;

import com.stan.dal.mapper.BookDOMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/22 12:31 下午
 * @Modified By：
 */

public class AppTestGeneratorDal {

    public static void main(String[] args) throws Exception {
        // 加载spring配置
        ApplicationContext context = new AnnotationConfigApplicationContext("com.stan.dal");
        System.out.println("Spring start...");

        BookDOMapper bookMapper = context.getBean(BookDOMapper.class);
        System.out.println(bookMapper.selectByPrimaryKey(1L));
    }

}
