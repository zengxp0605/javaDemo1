package com.stan.test;


import com.jason.base.config.MyProperties1;
import com.jason.base.service.TestService;
import com.stan.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/11/11 下午11:35
 * @Modified By：
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private UserService userService;

    @Autowired
    MyProperties1 myProperties1;

    @RequestMapping("/")
    public Object home() {

        testService.a();

        testService.b();

        System.out.println("--------userService---");

        userService.a();
        userService.b();
        userService.c();

        System.out.println("-------\n\n");
        System.out.println(myProperties1.getAddress());
        System.out.println(myProperties1.getName());
        return myProperties1;
    }
}
