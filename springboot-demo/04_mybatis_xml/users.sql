

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 测试关联查询
-- select * from users u left join user_family uf on u.id=uf.user_id where u.id=1;
DROP TABLE IF EXISTS `user_family`;
CREATE TABLE `user_family` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NOT NULL default 0 COMMENT '用户id, 关联users.id',
  `family_id` bigint(20) DEFAULT 0 COMMENT '家庭成员用户id',
  `family_role` varchar(32) DEFAULT NULL COMMENT '成员名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;