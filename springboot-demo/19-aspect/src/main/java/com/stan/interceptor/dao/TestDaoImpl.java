package com.stan.interceptor.dao;

import com.stan.interceptor.annotation.HttpApi;
import org.springframework.stereotype.Component;

/**
 * @author：zengxp
 * @date：2023/1/6 上午10:02
 */
@Component
public class TestDaoImpl implements TestDao {

    @Override
    public void query1() {
        System.out.println("method query11");
    }
}
