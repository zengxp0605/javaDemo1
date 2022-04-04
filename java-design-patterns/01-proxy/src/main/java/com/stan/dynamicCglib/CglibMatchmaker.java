package com.stan.dynamicCglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理人，媒婆
 */
public class CglibMatchmaker implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(clazz);
        // 设置回调
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是媒婆：帮你找对象啊");
        Object res = methodProxy.invokeSuper(o, args);
        System.out.println("我是媒婆：找的对象合适吗？合适拿红包来");

//        saveProxyClass(proxy);
        return res;
    }

}
