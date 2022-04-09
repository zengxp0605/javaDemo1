

package com.stan.swaggerdubbo.serviceImpl;

import com.stan.swaggerdubbo.api.entity.DubboTest;
import com.stan.swaggerdubbo.api.service.DubboTestService;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

import java.util.Random;

/**
 * The type Dubbo service.
 */
@DubboService
public class DubboTestServiceImpl implements DubboTestService {

    @Override
    public DubboTest findById(final String id) {
        return new DubboTest(id, "hello findById");
    }

    @Override
    public DubboTest findAll() {

        try {
            String attachment = RpcContext.getContext().getAttachment("add-value");
            System.out.println("attachment `add-value`: " + attachment);

            System.out.println("userId=" + RpcContext.getContext().getAttachment("userId"));
            System.out.println(RpcContext.getContext().getAttachments());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new DubboTest(String.valueOf(new Random().nextInt()), "hello world shenyu Alibaba Dubbo , findAll");
    }

    @Override
    public DubboTest insert(final DubboTest dubboTest) {
        dubboTest.setName("hello world shenyu Alibaba Dubbo: " + dubboTest.getName());
        return dubboTest;
    }

}
