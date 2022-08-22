
# eureka为注册中心的微服务

1. 启动 eureka-server项目
    访问 <http://localhost:8763/>，查看注册的服务（此时为空）
2. 启动多个端口的client-user-service项目
    ```
   java -jar -Xmx256m 02-client-user-service-1.0.0-SNAPSHOT.jar --server.port=8701
   java -jar -Xmx256m 02-client-user-service-1.0.0-SNAPSHOT.jar --server.port=8702
   java -jar -Xmx256m 02-client-user-service-1.0.0-SNAPSHOT.jar --server.port=8703
   ``` 
3. 启动api-gateway项目
    访问<http://127.0.0.1:8888/api/user>，可以看到请求被负载均衡到不同端口的`user-service`应用
    