package com.stan.interceptor.interceptor;

import com.stan.interceptor.annotation.HttpApi;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 3:18 下午
 * @Modified By：
 */
public class HttpApiInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        if (!method.isAnnotationPresent(HttpApi.class)) {
            return invocation.proceed();
        }

        String methodName = method.getName();
        HttpApi annotationHttpApi = method.getAnnotation(HttpApi.class);

        System.out.println("---------------cutPoint-------before: " + methodName);
        System.out.println("--->annotationValue: " + annotationHttpApi.value());
        Object proceed = invocation.proceed();
        System.out.println("---------------cutPoint-------end: " + methodName);


        return proceed;
    }
}
