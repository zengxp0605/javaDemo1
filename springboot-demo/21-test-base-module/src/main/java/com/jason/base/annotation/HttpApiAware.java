package com.jason.base.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 2:06 下午
 * @Modified By：
 */
@Component
@Aspect
public class HttpApiAware {

    @Pointcut("@annotation(HttpApi)")
    public void cutPoint() {

    }

    @Around("cutPoint()")
    public Object round(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        HttpApi httpApiAnnotation = signature.getMethod().getAnnotation(HttpApi.class);
        final String annotationValue = httpApiAnnotation.value();

        System.out.println("---------------cutPoint-------before: " + methodName);
        System.out.println("--->annotationValue: " + annotationValue);
        Object res = joinPoint.proceed();
        System.out.println("---------------cutPoint-------end: " + methodName);
        return res;
    }
}
