package com.stan.springmybatis.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/30 6:55 下午
 * @Modified By：
 */
@Configuration
@MapperScan(basePackages = "com.stan.springmybatis.mapper")
@PropertySource("classpath:mybatis-datasources.properties")
public class DalConfig {

    @Value("classpath:mapper/*.xml")
    private Resource[] mapperLocations;

    @Value("${connection.url}")
    private String url;

    @Value("${connection.username}")
    private String username;

    @Value("${connection.password}")
    private String password;

    @Lazy(false)
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory localSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);
//        sqlSessionFactoryBean.setTypeHandlers(new TypeHandler[]{new TestTypeHandle(),new GPTypeHandler()});
//        sqlSessionFactoryBean.setTypeHandlersPackage("com.gupao.dal.typehandles");
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{new TestPlugin()});
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor()});
        SqlSessionFactory factory = sqlSessionFactoryBean.getObject();
//        factory.getConfiguration().setLazyLoadingEnabled(true);
//        factory.getConfiguration().setAggressiveLazyLoading(false);
//        factory.getConfiguration().setProxyFactory(new CglibProxyFactory());
        return factory;
    }

//    private PageInterceptor pageInterceptor() {
//        PageInterceptor pageInterceptor = new PageInterceptor();
//        Properties properties = new Properties();
//        properties.put("helperDialect", "mysql");
//        pageInterceptor.setProperties(properties);
//        return pageInterceptor;
//    }

    @Primary
    @Lazy(false)
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(localSessionFactoryBean(), ExecutorType.SIMPLE);
    }

    @Lazy(false)
    @Bean(name = "batchSst")
    public SqlSessionTemplate batchSst() throws Exception {
        return new SqlSessionTemplate(localSessionFactoryBean(), ExecutorType.BATCH);
    }
//
//    @Bean(name = "txManager")
//    public DataSourceTransactionManager dataSourceTransactionManager() {
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
//        dataSourceTransactionManager.setDataSource(dataSource);
//        return dataSourceTransactionManager;
//    }

    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setConnectionProperties("config.decrypt=true");
//        dataSource.setFilters("stat,config");
        dataSource.setFilters("stat");
        dataSource.setMaxActive(20);
        dataSource.setInitialSize(20);
        dataSource.setMaxWait(60000);
        dataSource.setMinIdle(1);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(false);
        dataSource.setMaxOpenPreparedStatements(20);
        dataSource.setProxyFilters(Arrays.asList(statFilter()));
        dataSource.setConnectionErrorRetryAttempts(5);
        return dataSource;
    }

    @Bean
    public Filter statFilter() {
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(2000);
        statFilter.setLogSlowSql(true);
        return statFilter;
    }
}
