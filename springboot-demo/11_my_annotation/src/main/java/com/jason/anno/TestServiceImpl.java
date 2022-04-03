package com.jason.anno;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2022/1/10 下午10:05
 * @Modified By：
 */
public class TestServiceImpl implements ITestService{
    @Override
    public void test1(int a, int b) {
        System.out.println("test1");
    }

    @Override
    public void test2(int a, int b) {
        System.out.println("test2");
    }
}
