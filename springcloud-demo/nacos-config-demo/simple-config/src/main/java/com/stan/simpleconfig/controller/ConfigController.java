package com.stan.simpleconfig.controller;


import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.alibaba.nacos.NacosConfigProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${testString:}")
    private String testString;

    /**
     * 写入配置： curl -X POST "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=nacos-simple-config.properties&group=DEFAULT_GROUP&content=useLocalCache=true"
     * 获取配置： http://localhost:8083/config/get
     */
    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }

    @RequestMapping("/getString")
    public String getString() {
        return testString;
    }

    @RequestMapping("/test")
    public Object test() {
        try {
            String content = nacosConfigProperties.configServiceInstance().getConfig("gateway-router", "DEFAULT_GROUP", 5000L);
            System.out.println("配置内容： " + content);

            return content;
        } catch (NacosException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}