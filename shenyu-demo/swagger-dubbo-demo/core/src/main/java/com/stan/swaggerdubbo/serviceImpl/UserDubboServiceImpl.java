package com.stan.swaggerdubbo.serviceImpl;

import com.stan.swaggerdubbo.api.dto.LoginRequestDTO;
import com.stan.swaggerdubbo.api.dto.LoginResponseDTO;
import com.stan.swaggerdubbo.api.service.UserDubboService;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author zengxp
 * @date 2022/1/21 12:20
 */
@DubboService
public class UserDubboServiceImpl implements UserDubboService {

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        return new LoginResponseDTO();
    }

    @Override
    public boolean login(String account, int code) {
        return false;
    }
}
