package com.stan.interceptor.config;

import com.stan.interceptor.annotation.HttpApi;
import com.stan.interceptor.interceptor.HttpApiInterceptor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 3:17 下午
 * @Modified By：
 */
@Configuration
public class AppConfig {

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    public TestMethodAdvisor testMethodAdvisor() {
        TestMethodAdvisor advisor = new TestMethodAdvisor();
        advisor.setAdvice(httpApiInterceptor());
        advisor.setOrder(1); // 设置顺序，值越小优先级越高
        return advisor;
    }

    @Bean
    public HttpApiInterceptor httpApiInterceptor() {
        return new HttpApiInterceptor();
    }

    static class TestMethodAdvisor extends StaticMethodMatcherPointcutAdvisor {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return method.isAnnotationPresent(HttpApi.class)
                    || targetClass.isAnnotationPresent(HttpApi.class);
        }
    }
}
