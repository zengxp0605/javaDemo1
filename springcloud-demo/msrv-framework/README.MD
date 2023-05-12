
## msrv 架构层级

顶层 facade, 项目间调用，可以使用 dto

控制层 controller, facade的实际实现，调用biz层 使用dto

业务层 biz， 调用（core, dao)层，可以使用dto, do

核心层 core, biz公共业务，调用dao，可以使用dto, do

数据访问层 dao, 访问数据库，使用do

通用模块 common

-- 
web层，启动服务，基础配置

test 测试模块 


## 项目间关系说明

guard-server服务调用 user-server服务。


## 网关gateway，测试脚本在 user-test 包
- 调用user服务
http://localhost:8888/api/user/v1/address/getAll

- 调用guard服务
http://localhost:8888/api/guard/feign

## 附录

1. 快速配置apollo: <https://www.apolloconfig.com/#/zh/deployment/quick-start>

修改demo.sh
```shell script
# apollo config db info
apollo_config_db_url=jdbc:mysql://${MYSQL_URL}/ApolloConfigDB?characterEncoding=utf8&serverTimezone=Asia/Shanghai
apollo_config_db_username=${MYSQL_USER:-test}
apollo_config_db_password=${MYSQL_PASSWORD:-123456}

# apollo portal db info
apollo_portal_db_url=jdbc:mysql://${MYSQL_URL}/ApolloPortalDB?characterEncoding=utf8&serverTimezone=Asia/Shanghai
apollo_portal_db_username=${MYSQL_USER:-test}
apollo_portal_db_password=${MYSQL_PASSWORD:-123456}
```
