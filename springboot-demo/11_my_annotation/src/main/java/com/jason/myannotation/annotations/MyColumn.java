package com.jason.myannotation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义字段注解
 */
@Retention(RetentionPolicy.RUNTIME) // 要用到反射,所以注解信息需要保留到运行时
@Target(ElementType.FIELD) // 注解只能用在类属性上
public @interface MyColumn {

    // 字段名
    String value();

    // 字段类型, 默认为 varchar
    String type() default "varchar(30)";

    MyConstraints constraints() default @MyConstraints;
}
