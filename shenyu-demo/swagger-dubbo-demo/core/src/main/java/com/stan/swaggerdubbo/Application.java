package com.stan.swaggerdubbo;

import com.alibaba.nacos.common.tls.TlsSystemConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zengxp
 * @date 2022/1/21 11:01
 */
@SpringBootApplication
@EnableDubbo
public class Application {
    public static void main(String[] args) {
        String env = System.getenv("ENVIRONMENT");
        if (StringUtils.isBlank(env)) {
            System.setProperty(TlsSystemConfig.TLS_ENABLE, "true");
            // shenyu 本地环境多网卡优先级
            System.setProperty("networkInterface.priority", "ppp<eth<bond<en");
        }
        SpringApplication.run(Application.class, args);
    }
}
