package com.stan.singleton;

/**
 * 双重校验锁 Double Checked Locking
 */
public class DclSingleton {
    // 使用volatile关键字，禁止代码段重排序
    private static volatile DclSingleton INSTANCE;

    // 私有构造方法，禁止外部`new DclSingleton()`操作
    private DclSingleton(){}

    public static DclSingleton getInstance(){
        if(null == INSTANCE){
            synchronized (DclSingleton.class){
                // 再次验证 INSTANCE 未实例化
                if(null == INSTANCE){
                    INSTANCE = new DclSingleton();
                }
            }
        }

        return INSTANCE;
    }


    // 测试用
    public void foo(){
        System.out.println("双重校验锁 foo");
    }
}
