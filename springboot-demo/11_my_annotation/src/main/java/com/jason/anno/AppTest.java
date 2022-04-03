package com.jason.anno;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2022/1/10 下午10:05
 * @Modified By：
 */
public class AppTest {
    public static void main(String[] args) {

        testProxy();

        Annotation[][] parameterAnnotations = ITestService.class.getDeclaredMethods()[0].getParameterAnnotations();
        System.out.println(parameterAnnotations);


        Method[] declaredMethods = TestServiceImpl.class.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            Annotation[][] parameterAnnotations1 = declaredMethod.getParameterAnnotations();
            System.out.println(parameterAnnotations1);
        }

        Class<?>[] interfaces = TestServiceImpl.class.getInterfaces();

        System.out.println(interfaces);
    }

    public static void testProxy() {

        InvocationHandler handler = new TestInvocationHandler<>(new TestServiceImpl());

        ITestService testService = (ITestService) Proxy.newProxyInstance(ITestService.class.getClassLoader(),
                new Class<?>[]{ITestService.class},
                handler);
        System.out.println("package = " + testService.getClass().getPackage() + " SimpleName = " + testService.getClass().getSimpleName()
                + " name =" + testService.getClass().getName() + " CanonicalName = " + "" + testService.getClass().getCanonicalName()
                + " 实现的接口 Interfaces = " + Arrays.toString(testService.getClass().getInterfaces())
                + " superClass = " + testService.getClass().getSuperclass() + " methods =" + Arrays.toString(testService.getClass().getMethods()));
    }
}
