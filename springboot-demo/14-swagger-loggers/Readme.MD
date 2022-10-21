
# actuator prometheus 使用示例


## 基于Swagger构建的Rest API文档
  
api地址： <http://localhost:8080/swagger-ui.html>


## 动态修改日志
- 查看详情：<http://localhost:8080/actuator/loggers>

- 配置
```
management.endpoints.web.exposure.include: loggers
#显示健康具体信息  默认不会显示详细信息
management.endpoint.health.show-details: always
```

- 修改日志级别
```shell script
curl -X POST -H "Content-Type:application/json" \
  --data '{"configuredLevel": "DEBUG"}' \
  "http://localhost:8080/actuator/loggers/cn"
```