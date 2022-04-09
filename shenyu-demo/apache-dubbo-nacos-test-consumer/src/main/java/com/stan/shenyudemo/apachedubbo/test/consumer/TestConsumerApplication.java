package com.stan.shenyudemo.apachedubbo.test.consumer;

import com.alibaba.nacos.common.tls.TlsSystemConfig;
import com.stan.shenyudemo.dubboapi.service.DubboTestService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zengxp
 * @Date: 2021/12/16 14:27
 * @Desc:
 */
@SpringBootApplication
@EnableDubbo
public class TestConsumerApplication {
    public static void main(final String[] args) {
        System.out.println("查看TestController");
        // 本地开发环境，才走SSL
        String env = System.getenv("ENVIRONMENT");
        if (StringUtils.isBlank(env)) {
            System.setProperty(TlsSystemConfig.TLS_ENABLE, "true");
            // shenyu 本地环境多网卡优先级
            System.setProperty("networkInterface.priority", "ppp<eth<bond<en");
        }
        SpringApplication.run(TestConsumerApplication.class, args);
    }
}