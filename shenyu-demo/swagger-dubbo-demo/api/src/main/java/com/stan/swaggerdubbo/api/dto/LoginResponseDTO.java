package com.stan.swaggerdubbo.api.dto;


import com.stan.swaggerdubbo.api.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "最后登录时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;


    @ApiModelProperty(value = "传给第三方的openUserId")
    private String openUserId;

    @ApiModelProperty(value = "用户实体详情")
    private User user;
}
