package com.stan.learnmybatis;

import com.stan.learnmybatis.mapper.BookMapper;
import com.stan.learnmybatis.pojo.BookPO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/22 12:31 下午
 * @Modified By：
 */
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        try {
//        // 加载spring配置
//        ApplicationContext context = new ClassPathXmlApplicationContext("server.xml");
////       new AnnotationConfigApplicationContext("com.stan.learn.mybatis");
            System.out.println("start...");

            // 指定全局配置文件
            String resource = "mybatis-config.xml";
            // 读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 构建sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();

            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            BookPO bookPO = sqlSession.selectOne("findBook", 1);
            System.out.println(bookPO);

            // 测试使用命名空间查询一条记录（接口）
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            System.out.println(bookMapper.findBook(1));

            // 测试获取一个列表
            List<BookPO> books = bookMapper.listBooks();
            System.out.println("books size: " + books.size());
            System.out.println(Arrays.toString(books.toArray()));

            // 插入一条数据
            BookPO bookParam = new BookPO();
            bookParam.setAuthor("Zeng").setBookName("中文test").setCreateTime(new Date());
            bookMapper.insertBook(bookParam);
            System.out.println("插入数据返回的id: " + bookParam.getId());
            // 需要手动commit 否则数据会被回滚
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
