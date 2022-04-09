package com.stan.swaggerdubbo.api.service;

import com.stan.swaggerdubbo.api.dto.LoginRequestDTO;
import com.stan.swaggerdubbo.api.dto.LoginResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengxp
 * @date 2022/1/21 10:41
 */
@Api(tags = "用户接口")
public interface UserDubboService {
    @ApiOperation(value = "接口1-test1")
    default List<String> test1(Integer num) {
        ArrayList<String> strings = new ArrayList<String>() {{
            add("123");
            add(num + "");
        }};
        return strings;
    }

    @ApiOperation(value = "登录接口", notes = "这是登录接口notes")
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);

    @ApiOperation(nickname = "byCode", value = "登录", notes = "邀请码登录")
    boolean login(@ApiParam(value = "用户帐号") String account, @ApiParam(value = "邀请码") int code);
}
