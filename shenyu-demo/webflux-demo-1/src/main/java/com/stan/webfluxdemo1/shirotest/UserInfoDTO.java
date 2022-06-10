package com.stan.webfluxdemo1.shirotest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author caizm@fosun.com
 * @date 2021-04-27 17:17
 * @desc
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString
public class UserInfoDTO implements Serializable {
    private static final long serialVersionUID = 1682062653344339253L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 域ID
     */
    private Integer domainId;

    /**
     * 渠道
     */
    private String channel;
}
