package com.stan.shenyundemo.apachedubbo.server;

import com.alibaba.nacos.common.tls.TlsSystemConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zengxp
 * @Date: 2021/12/16 13:52
 * @Desc:
 */
@SpringBootApplication(scanBasePackages="com.stan.shenyundemo.apachedubbo.server")
@EnableDubbo
@ServletComponentScan
public class TestApacheDubboApplication {
    public static void main(final String[] args) {
        // 本地开发环境，才走SSL
        String env = System.getenv("ENVIRONMENT");
        if (StringUtils.isBlank(env)) {
            System.setProperty(TlsSystemConfig.TLS_ENABLE, "true");
            // shenyu 本地环境多网卡优先级
            System.setProperty("networkInterface.priority", "ppp<eth<bond<en");
        }

        SpringApplication.run(TestApacheDubboApplication.class, args);
    }

    @RestController
    class TestController{
        @RequestMapping("/")
        public Object test(){
            System.out.println("test-22");
            return "test22";
        }
    }
}
