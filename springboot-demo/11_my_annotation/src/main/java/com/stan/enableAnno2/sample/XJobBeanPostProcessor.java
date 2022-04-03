package com.stan.enableAnno2.sample;


import com.stan.enableAnno2.annotations.XJobHandler;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class XJobBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
    private String configPackage;

    private ConfigurableListableBeanFactory configurableListableBeanFactory;

    public String getConfigPackage() {
        return configPackage;
    }

    public void setConfigPackage(String configPackage) {
        this.configPackage = configPackage;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        configurableListableBeanFactory = (ConfigurableListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClazz = AopUtils.getTargetClass(bean);
        String beanClassName = beanClazz.getName();

        if (!beanClassName.startsWith(configPackage)) {
//            System.out.println(beanClassName + "不是这个包下面的" + configPackage);
            return bean;
        }

        System.out.println("beaName: " + beanName);
        System.out.println("beanClassName: " + beanClassName);

        Map<String, Method> methodMap = getMethodsByAnno(beanClazz);
        System.out.println(methodMap);
        if (methodMap.isEmpty()) {
            return bean;
        }

        methodMap.forEach((definedName, method) -> {
            // 手动生成 XJobListener 并放入到spring 容器
            configurableListableBeanFactory.registerSingleton(definedName,
                    new XJobListener(definedName, method, bean)
            );
        });

        return bean;
    }

    private Map<String, Method> getMethodsByAnno(Class<?> beanClazz) {
        Map<String, Method> methodMap = new HashMap<>();
        for (Method method : beanClazz.getMethods()) {
            if (method.isAnnotationPresent(XJobHandler.class)) {
                // 这里可以判断传入的参数
                int paramsCount = method.getParameterTypes().length;
                if (paramsCount == 0
                        || !method.getParameterTypes()[0].isAssignableFrom(JobExecutionContext.class)
                ) {
                    throw new RuntimeException("XJobHandler参数有误");
                }

                XJobHandler xJobHandlerBean = method.getAnnotation(XJobHandler.class);
                methodMap.put(xJobHandlerBean.value(), method);
            }
        }
        return methodMap;
    }


}
