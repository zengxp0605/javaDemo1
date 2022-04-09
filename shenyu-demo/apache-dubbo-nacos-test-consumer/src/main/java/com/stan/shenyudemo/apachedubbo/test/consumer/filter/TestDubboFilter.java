package com.stan.shenyudemo.apachedubbo.test.consumer.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @Author: zengxp
 * @Date: 2022/1/6 18:04
 * @Desc:
 */
@Activate(group = CommonConstants.CONSUMER, order = -10000)
public class TestDubboFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("-------->TestDubboFilter");
        return invoker.invoke(invocation);
    }
}
