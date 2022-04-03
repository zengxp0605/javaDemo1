package com.stan.enableAnno2.annotations;

import com.stan.enableAnno2.sample.MyAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyAutoConfiguration.class)
public @interface EnableAnnoXJob {
    @AliasFor("basePackage")
    String value() default "";

    @AliasFor("value")
    String basePackage() default "";

    int aDefaultVal() default 1000;
}
