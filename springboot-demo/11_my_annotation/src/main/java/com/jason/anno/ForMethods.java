package com.jason.anno;


import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME) // 要用到反射,所以注解信息需要保留到运行时
@Target(ElementType.METHOD)
//@Inherited
public @interface ForMethods {

    String value() default "default";

}
