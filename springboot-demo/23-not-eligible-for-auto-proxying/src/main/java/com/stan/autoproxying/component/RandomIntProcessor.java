package com.stan.autoproxying.component;

import com.stan.autoproxying.annotation.RandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * @author：zengxp
 * @date：2022/4/23 下午4:08
 */
@Component
public class RandomIntProcessor implements BeanPostProcessor {

    /**
     * 重点在这个地方注入时需要加上 @Lazy, 延迟注入对象属性
     */
//    @Lazy
//    @Autowired
    private RandomIntGenerator randomIntGenerator;

    @Lazy
    RandomIntProcessor(RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 遍历所有字段，找到符合 @RandomInt 注解的字段
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            RandomInt randomInt = field.getAnnotation(RandomInt.class);
            if (null != randomInt) {
                int min = randomInt.min();
                int max = randomInt.max();
                int num = this.randomIntGenerator.generate(min, max);
                // 通过反射强行注入字段值
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, num);
            }
        }

        return bean;
    }
}
