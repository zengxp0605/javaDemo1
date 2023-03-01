package com.stan.multiImpl.test.controller;

import com.stan.multiImpl.test.intf.AccountCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private AccountCore accountCore;

    @PostConstruct
    public void init(){
        System.out.println("ProductController init");
    }

    @GetMapping("/product")
    public Map<String, Object> test(){

        String channelNo = accountCore.getChannelNo();
        System.out.println(channelNo);

        return new HashMap<String, Object>(){{
            put("channelNo", channelNo);
        }};
    }
}
