package com.stan.shenyundemo.apachedubbo.server.dubboclient;

import java.lang.annotation.*;

/**
 * @Author: zengxp
 * @Date: 2021/12/24 12:21
 * @Desc:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface OpenApiTest {

    /**
     * Path string.
     *
     * @return the string
     */
    String path();

    /**
     * Rule name string.
     *
     * @return the string
     */
    String ruleName() default "";

    /**
     * Desc string.
     *
     * @return String string
     */
    String desc() default "";

    /**
     * Enabled boolean.
     *
     * @return the boolean
     */
    boolean enabled() default true;
}
