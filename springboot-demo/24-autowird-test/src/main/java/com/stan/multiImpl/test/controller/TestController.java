package com.stan.multiImpl.test.controller;

import com.stan.multiImpl.test.intf.AccountCore;
import com.stan.multiImpl.test.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private AccountCore accountCoreImpl; // 默认byType注入，多个实现类则使用byName注入，变量名为默认的name

    @Autowired
    private AccountCore accountWXCoreImpl;

    /**  使用 @Qualifier 结合 @Primary 注入指定name的实现类    */
    @Autowired
    private UserService userService;
    @Autowired
    private UserService userService2Impl;

    @Autowired
    @Qualifier("userService2Impl")
    private UserService userService3;

    @GetMapping("/test")
    public Map<String, Object> test(){
        Map<String,Object> map= new HashMap<>();

        map.put("default", accountCoreImpl.getChannelNo());
        map.put("wx", accountWXCoreImpl.getChannelNo());

        System.out.println(userService.getClass().getSimpleName());
        System.out.println(userService2Impl.getClass().getSimpleName());
        System.out.println(userService3.getClass().getSimpleName());

        return map;
    }
}
