package com.jason.anno;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2022/1/10 下午10:04
 * @Modified By：
 */
public interface ITestService {

    void test1(
            @ForParams int a,
            @ForParams int b
    );

    @ForMethods
    void test2(
            int a,
            int b
    );
}
