package com.stan.shenyudemo.apachedubbo.test.consumer.contorller;

import com.stan.shenyudemo.dubboapi.entity.DubboTest;
import io.swagger.annotations.ApiOperation;

/**
 * @author zengxp
 * @date 2022/1/13 18:08
 */
public interface InterfaceForTest {

    @ApiOperation("Test接口1")
    Object test();

    @ApiOperation("Test接口222")
    Object test2(DubboTest dubboTest);
}
