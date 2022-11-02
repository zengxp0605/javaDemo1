package com.stan.nbspring.controller;

import com.stan.nbspring.facade.dto.UserDto;
import com.stan.nbspring.facade.intf.IUserAccountManage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过实现接口对外暴露服务， 接口同 feign
 *
 */
@RestController
@RequestMapping("/v1/user")
public class UserAccountController implements IUserAccountManage {

    @PostConstruct
    public void init(){
        System.out.println("--->UserAccountController init...");
    }

    @Override
    public Boolean add() {
        return true;
    }

    @Override
    public List<UserDto> list() {
        List<UserDto> users = new ArrayList<>();
        users.add(new UserDto("Tom"));
        users.add(new UserDto("Cherry"));
        return users;
    }
}
