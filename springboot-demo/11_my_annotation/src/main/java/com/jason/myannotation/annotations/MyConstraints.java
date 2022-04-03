package com.jason.myannotation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义字段约束注解
 */
@Retention(RetentionPolicy.RUNTIME) // 要用到反射,所以注解信息需要保留到运行时
@Target(ElementType.FIELD)
public @interface MyConstraints {

    // 是否为主键约束
    boolean primaryKey() default false;

    // 是否允许为null
    boolean nullable() default false;

    // 字段是否唯一
    boolean unique() default false;
}
