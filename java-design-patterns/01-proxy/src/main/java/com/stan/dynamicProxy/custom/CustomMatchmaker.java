package com.stan.dynamicProxy.custom;

import com.stan.dynamicProxy.Person;

import java.lang.reflect.Method;

/**
 * 代理人，媒婆
 */
public class CustomMatchmaker implements MyInvocationHandler {

    private Person target;

    public Object getInstance(Person target) {
        this.target = target;
        return MyProxy.newProxyInstance(new MyClassLoader(),
                new Class[]{Person.class}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：帮你找对象啊");
        Object result = method.invoke(target, args);
        System.out.println("我是媒婆：找的对象合适吗？合适拿红包来");

        return result;
    }

}
