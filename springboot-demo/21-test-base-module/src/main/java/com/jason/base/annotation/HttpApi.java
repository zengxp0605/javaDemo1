package com.jason.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/3/25 1:57 下午
 * @Modified By：
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface HttpApi {
    String value() default "";
}
