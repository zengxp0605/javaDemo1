
# SpringBoot 学习过程中的一些demo

## 模块目录说明
- 00_basejava
  - java基础: 基础数据类型,
- 01_hello
  - helloWorld
- 02jpa
  - jpa 数据库连接
- 03_redis
  - 简单redis连接, session-redis
- 04_mybatis
  - 简单数据库连接,mybatis 注解的方式
- 04_mybatis_xml
  - 简单数据库连接,mybatis xml配置sql的方式
  - 含数据库事务/回滚的测试
  - 连表查询
  - 测试war包打包方式,放到tomcat下执行成功
- 05_mybatis_multi
  - mybatis 多数据源(多个库)的连接方式

- 06_groovy_tst
  - 使用`groovy`写测试用例
  - TODO: 调用数据库没有跑通

- 07_RabbitMQ
  - 需要先安装[Erlang](https://www.erlang.org/downloads)
    - 配置环境变量 ERLANG_HOME=E:\Program Files\erl9.0
  - 再安装[RabbitMQ](https://www.rabbitmq.com/download.html)
  - 启动RabbitMQ
  - TODO:
    - Topic Exchange: 可以根据 routing_key 自由的绑定不同的队列
    - Fanout Exchange: 就是我们熟悉的广播模式或者订阅模式

- 08_upload_file
  - 配置最大上传文件不超过10MB
 
- 09_rpc_dubbo
> (https://blog.csdn.net/alinyua/article/details/81019925)
  - 先安装并启动 [zookeeper](http://mirrors.hust.edu.cn/apache/zookeeper/)
  - `09_rpc_dubbo/dubbo-server` 服务提供者 `provider`
  - `09_rpc_dubbo/dubbo-client` 服务消费者(web服务,api) `consumer`
  - `09_rpc_dubbo/base-interface` 公开基础接口

- 13-springboot-strategy
  - springboot注解实现策略模式 @Autowired

- 15-application-event
  - 事件监听的方式，解藕业务逻辑
  
- 16-quartz
  - 定时任务


## 参考: 
- [Spring Boot 系列文章](http://www.ityouknow.com/spring-boot.html)  
- [https://github.com/ityouknow/spring-boot-examples](https://github.com/ityouknow/spring-boot-examples);
