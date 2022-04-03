package com.stan.delegete;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/4/8 6:15 下午
 * @Modified By：
 */
public class TargetB implements ITarget {
    public void doWork(String command) {
        System.out.println("TargetB doWork: sell ");
    }
}
