package com.stan.dynamicProxy.jdk;

import com.stan.dynamicProxy.Person;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理人，媒婆
 */
public class Matchmaker implements InvocationHandler {

    private Person target;

    public Object getInstance(Person target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                new Class[]{Person.class}, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：帮你找对象啊");
//        this.target.findLover();
        Object result = method.invoke(target, args);
        System.out.println("我是媒婆：找的对象合适吗？合适拿红包来");

        saveProxyClass(proxy);

        return result;
    }

    private void saveProxyClass(Object proxy) {
        /**
         * 保存动态生成的字节码文件
         */
        System.out.println(proxy.getClass().getName());
        System.out.println(proxy.getClass().getSimpleName());
        byte[] bytes = ProxyGenerator.generateProxyClass(proxy.getClass().getSimpleName(),
                new Class[]{proxy.getClass()});

        try {
            File file = new File("$Proxy0.class");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
