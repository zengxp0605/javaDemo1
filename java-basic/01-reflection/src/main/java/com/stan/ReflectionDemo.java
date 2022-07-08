package com.stan;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zengxp
 */
public class ReflectionDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 通过类名 User.class
        Method[] methods = User.class.getDeclaredMethods();
        System.out.println(Arrays.asList(methods));

        // 2. 通过new出来的实例对象
        User user = new User();
        Method[] methods1 = user.getClass().getDeclaredMethods();
        System.out.println(Arrays.asList(methods1));

        // 3. 通过路径加载类
        Class<?> clazz = Class.forName("com.stan.ReflectionDemo$User");
        System.out.println(Arrays.asList(clazz.getDeclaredMethods()));

        // 4. 通过xxxClassLoader加载类
        Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass("com.stan.ReflectionDemo$User");
        System.out.println(Arrays.asList(loadClass.getDeclaredMethods()));

    }

    public static class User {
        private int id;
        private String name;

        public void speak(String words){
            System.out.println(words);
        }
    }
}
