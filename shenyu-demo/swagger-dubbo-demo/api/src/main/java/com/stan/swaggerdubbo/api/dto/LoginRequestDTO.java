package com.stan.swaggerdubbo.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;


@Data
public class LoginRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("手机号")
    private String mobileNo;

    @ApiModelProperty("短信验证码")
    private String otpCode;
}
