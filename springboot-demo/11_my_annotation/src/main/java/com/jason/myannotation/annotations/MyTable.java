package com.jason.myannotation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解, 完成 类和表的 映射
 */
@Retention(RetentionPolicy.RUNTIME) // 要用到反射,所以注解信息需要保留到运行时
@Target(ElementType.TYPE) // 注解只能用在类上
public @interface MyTable {

    // 表名
    String value();
}
