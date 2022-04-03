package com.jason.functionInterface;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterfaceDemo {
    public static void main(String[] args) {

        // 有且只有一个抽象方法的接口被称为函数式接口
        DemoFunction demoFunction = new DemoFunction();
        demoFunction.print("测试实现的方法");

        printString("试试接口的使用", System.out::print);


        // 常用函数式接口
        System.out.println("==============函数型接口==========");
        fun();

        System.out.println("============consumer===========");
        consumer();

        System.out.println("============supplier===========");
        supplier();

        System.out.println("============predicate===========");
        predicate();
    }

    private static void printString(String text, IDemoInterface myFunc) {
        myFunc.print(text);
    }

    /**
     * Function<T,R>: 函数型接口
     * 抽象方法： R apply(T t)，传入一个参数，返回想要的结果。
     */
    public static void fun() {
        Function<Integer, Integer> func = i -> i * 10;
        int res = func.apply(10);
        System.out.println("func res: " + res);
    }

    /**
     * Consumer<T>：消费型接口
     * 抽象方法： void accept(T t)，接收一个参数进行消费，但无需返回结果。
     */
    public static void consumer() {
        Consumer<String> consumer1 = s -> System.out.print("车名: " + s.split(",")[0]);
        Consumer<String> consumer2 = s -> System.out.println(" -->颜色: " + s.split(",")[1]);

        String[] strings = {"保时捷,白色", "法拉利,红色"};
        for (String str : strings) {
            consumer1.andThen(consumer2).accept(str);
        }
    }

    /**
     * Supplier<T>: 供给型接口
     * 抽象方法：T get()，无参数，有返回值。
     */
    public static void supplier() {
        Supplier<String> supplier = () -> {
            String str = "Hey zouzou.";
            return str;
        };

        String str = supplier.get();
        System.out.println(str);
    }

    /**
     * Predicate<T> ： 断言型接口
     * 抽象方法： boolean test(T t),传入一个参数，返回一个布尔值。
     */
    public static void predicate() {
        Predicate<String> predicate1 = s -> s.length() > 0;
        Predicate<String> predicate2 = s -> s.startsWith("&");
        Predicate<String> predicate3 = Objects::nonNull;
        boolean test = predicate1.and(predicate2).or(predicate3).test("&&测试");
        System.out.println(test);
    }
}
