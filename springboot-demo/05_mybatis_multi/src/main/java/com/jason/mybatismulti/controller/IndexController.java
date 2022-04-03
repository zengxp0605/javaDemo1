package com.jason.mybatismulti.controller;

import com.jason.mybatismulti.entity.Cat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(value = "/")
    public String home(){
        return "Hi index";
    }

    /**
     * 测试 lombok 的使用
     * @return
     */
    @RequestMapping(value = "/getCat")
    public Object getCat(){
        Cat cat = new Cat();
        cat.setLegCount(4);
        cat.setSex((byte) 2);
        cat.setName("Xiao mi");
        System.out.println("Cat info: "+ cat.toString());
        return cat;
    }


}
