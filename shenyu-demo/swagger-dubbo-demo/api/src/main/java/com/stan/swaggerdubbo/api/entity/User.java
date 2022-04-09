package com.stan.swaggerdubbo.api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zengxp
 * @date 2022/1/21 10:48
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户Id")
    Integer id;

    @ApiModelProperty("用户昵称")
    String nickname;

    @ApiModelProperty("爱好")
    List<String> hobbits;
}
