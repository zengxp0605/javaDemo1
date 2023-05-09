package com.stan.guard.controller;

import com.stan.common.model.dto.CommonResult;
import com.stan.user.facade.dto.response.AddressResponseDto;
import com.stan.user.facade.feign.UserAddressFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/")
    public String test(){
        return "Response from port: " + port;
    }

    /**
     * 模块间调用
     */
    @Autowired
    private UserAddressFacade userAddressFacade;

    @RequestMapping("/feign")
    public Object feign(){

        CommonResult<List<AddressResponseDto>> list = userAddressFacade.getAll();

        System.out.println(list);

        return list;
    }
}
