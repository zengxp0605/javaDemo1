
# dog 表

```SQL
-- 创建表空间
create tablespace animal
datafile 'animal.dbf' size 10M;

-- 建表时指定表空间
create table dog
(
    name varchar(12),
    age varchar(12)
)
tablespace animal;

-- 查看表空间下的所有表
select tablespace_name, table_name from user_tables
where tablespace_name = 'ANIMAL';

-- 插入数据
insert into dog values('Tom', '5');
insert into dog(name) VALUES ('Lile');
```