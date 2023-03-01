package com.stan.interceptor.dao;

import com.stan.interceptor.annotation.HttpApi;

/**
 * @author：zengxp
 * @date：2023/1/6 上午10:02
 */
public interface TestDao {
    @HttpApi("api-on-query1")
    void query1();
}
