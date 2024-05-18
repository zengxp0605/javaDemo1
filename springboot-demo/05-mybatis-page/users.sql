

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into users (nick_name) values
    ('z1'),
    ('z2'),
    ('z3'),
    ('z4'),
    ('z5'),
    ('z6'),
    ('x1'),
    ('x2'),
    ('x3'),
    ('x4'),
    ('x5'),
    ('x6');

CREATE TABLE `t1_user` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                         `nick_name` varchar(32) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "临时测试表";