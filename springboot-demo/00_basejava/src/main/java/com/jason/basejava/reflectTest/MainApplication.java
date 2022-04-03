package com.jason.basejava.reflectTest;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射方法调用
 *
 */
public class MainApplication {
    public static void main(String[] args) throws Exception {
        test1();

        test2();

        testGetFields();


    }

    /**
     * 通过反射获取类属性、方法、构造器
     */
    public static void testGetFields() throws Exception {
        Class clz = Class.forName("com.jason.basejava.reflectTest.model.Apple");

        // getFields() 方法可以获取 Class 类的属性，但无法获取私有属性
        Field[] fields = clz.getFields();

        for (Field field: fields) {
            System.out.println("Field name: " + field.getName());
        }

        // getFields() 方法可以获取 Class 类的属性，但无法获取私有属性
        Field[] allFields = clz.getDeclaredFields();

        for (Field field: allFields) {
            System.out.println("All Field name: " + field.getName());
        }
    }

    /**
     * 使用 clz.getConstructor, 可以通过有参构造实例化对象
     *
     * @throws Exception
     */
    public static void test2() throws Exception {
        Class clz = Class.forName("com.jason.basejava.reflectTest.model.Apple");
        Constructor constructor = clz.getConstructor(int.class, String.class);
        Object appleObj = constructor.newInstance(21,"red");

        Method getPriceMethod = clz.getMethod("getPrice");
        int price = (int) getPriceMethod.invoke(appleObj);
        System.out.println("Apple price: " + price + " | Apple: " + appleObj);
    }

    /**
     * 使用 clz.newInstance
     * @throws Exception
     */
    public static void test1()  throws Exception {
        Class clz = Class.forName("com.jason.basejava.reflectTest.model.Apple");
        Object object = clz.newInstance();
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        setPriceMethod.invoke(object, 14);

        Method getPriceMethod = clz.getMethod("getPrice");
        int price = (int) getPriceMethod.invoke(object);
        System.out.println("Apple price: " + price);
    }
}
