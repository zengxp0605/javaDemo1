package com.stan.nbspring.facade.intf;

import com.stan.nbspring.facade.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 用户账号管理
 */
public interface IUserAccountManage {
    
    @PostMapping("/add")
    Boolean add();

    @GetMapping("/list")
    List<UserDto> list();
}
