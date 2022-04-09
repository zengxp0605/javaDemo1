package com.stan.shenyudemo.apachedubbo.test.consumer.contorller;

import com.fosun.user.api.dubbo.SysUserManageDubbo;
import com.stan.shenyudemo.dubboapi.entity.DubboTest;
import com.stan.shenyudemo.dubboapi.service.DubboTestService;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zengxp
 * @Date: 2021/12/16 14:34
 * @Desc:
 */
@RestController
public class TestController implements InterfaceForTest{
    //    @DubboReference
//    public DubboTestService dubboTestService;

    @RequestMapping("/test")
    public Object test() {
        System.out.println("--->test");
//        return dubboTestService.findAll();
//        sysUserManageDubbo.getUserListByChannel()
        return "test";
    }

    @RequestMapping("/test2")
    @Override
    public Object test2(DubboTest dubboTest) {
        return "test2";
    }

    /**
     * 范化调用
     *
     * @return
     */
    @RequestMapping("/testGeneric")
    public Object testGeneric() {
        System.out.println("--->testGeneric");
        // 引用远程服务
        // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        // 弱类型接口名
        reference.setInterface("com.stan.shenyudemo.dubboapi.service.DubboTestService");
        reference.setVersion("LATEST");
        // 声明为泛化接口
        reference.setGeneric("true");

        // 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();

        /**
         * 设置隐式参数
         * - provider获取  String attachment = RpcContext.getContext().getAttachment("add-value");
         */
        RpcContext.getContext().setAttachment("add-value", "value-append-to-attachment");

        RpcContext context = RpcContext.getContext();
        System.out.println(context.getParameterTypes());
        System.out.println(context.getMethodName());
        System.out.println(context.getArguments());

        // 基本类型以及Date,List,Map等不需要转换，直接调用
        Object result = genericService.$invoke("findById", new String[]{"java.lang.String", "java.lang.String"}, new Object[]{"xx-id-xx", "value-xx"});
        System.out.println("result: " + result);
        return result;
    }
}