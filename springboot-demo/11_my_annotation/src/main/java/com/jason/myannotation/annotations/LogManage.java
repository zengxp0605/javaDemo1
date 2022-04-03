package com.jason.myannotation.annotations;

import jdk.nashorn.internal.ir.annotations.Reference;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/7/30 2:09 下午
 * @Modified By：
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogManage {
    String value();
    String desc() default "my-log";
}
