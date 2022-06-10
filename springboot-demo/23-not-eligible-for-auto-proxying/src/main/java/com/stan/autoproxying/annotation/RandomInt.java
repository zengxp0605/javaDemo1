package com.stan.autoproxying.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author：zengxp
 * @date：2022/4/23 下午4:03
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomInt {
    int min();

    int max();
}
