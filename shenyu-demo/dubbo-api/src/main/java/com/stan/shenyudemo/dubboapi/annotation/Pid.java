package com.stan.shenyudemo.dubboapi.annotation;

import java.lang.annotation.*;

/**
 * @Author: zengxp
 * @Date: 2022/1/6 15:44
 * @Desc:
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Pid {
}
