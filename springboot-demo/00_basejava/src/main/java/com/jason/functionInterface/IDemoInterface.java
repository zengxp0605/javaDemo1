package com.jason.functionInterface;

/**
 * 在函数式接口的定义中是只允许有一个抽象方法，但是可以有多个static方法和default方法。
 */
@FunctionalInterface
public interface IDemoInterface {
    void print(String s);

    /**
     * 默认方法
     */
    default void defaultFunc(){
        System.out.println("hello defaultFunc ");
    }

    static  void staticFunc(){
        System.out.println("hello staticFunc ");
    }
}
