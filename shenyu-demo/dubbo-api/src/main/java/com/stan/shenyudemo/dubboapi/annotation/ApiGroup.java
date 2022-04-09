package com.stan.shenyudemo.dubboapi.annotation;

import java.lang.annotation.*;

/**
 * @Author: zengxp
 * @Date: 2022/1/6 15:42
 * @Desc:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface ApiGroup {
    String value() default "";
}
