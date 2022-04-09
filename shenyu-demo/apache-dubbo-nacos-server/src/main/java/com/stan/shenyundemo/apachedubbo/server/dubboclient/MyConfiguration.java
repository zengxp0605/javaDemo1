package com.stan.shenyundemo.apachedubbo.server.dubboclient;

import org.apache.shenyu.client.apache.dubbo.ApacheDubboServiceBeanListener;
import org.apache.shenyu.register.client.api.ShenyuClientRegisterRepository;
import org.apache.shenyu.register.common.config.ShenyuRegisterCenterConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: zengxp
 * @Date: 2021/12/24 11:24
 * @Desc:
 */
@Configuration
@ConditionalOnProperty(prefix = "shenyuopen", name = "enable", havingValue = "true")
public class MyConfiguration {

    @Bean
    public Object ob(){
        System.out.println("----> start ob" );
        return new Object();
    }

    @Bean
    public MyApacheDubboServiceBeanListener myApacheDubboServiceBeanListener(final MyShenyuRegisterCenterConfig shenyuRegisterCenterConfig,
                                                                         final ShenyuClientRegisterRepository shenyuClientRegisterRepository) {
        System.out.println("----> start" );
        return new MyApacheDubboServiceBeanListener(shenyuRegisterCenterConfig, shenyuClientRegisterRepository);
    }

    @Bean
    @ConfigurationProperties(prefix = "shenyuopen.client")
    public MyShenyuRegisterCenterConfig myShenyuRegisterCenterConfig() {

        System.out.println("----> start shenyuRegisterCenterConfig" );
        return new MyShenyuRegisterCenterConfig();
    }
}
