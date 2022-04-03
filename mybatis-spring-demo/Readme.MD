

# 学习 mybatis-spring 以及 spring

- xml 的方式有待完善


## db
```sql
use `test`;
CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `book_name` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='book';

```


## 03-mybatis-generator
1. 通过侧边栏的Maven-Plugins 找到 mybatis-generator:generate 执行

2. 或者配置 执行 mybatis-generator 插件
Add Configuration -> Maven -> Command Line [mybatis-generator:generate]
