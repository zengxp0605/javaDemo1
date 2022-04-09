package com.stan.webfluxdemo1.shirotest;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author caizm@fosun.com
 * @date 2021-04-27 17:17
 * @desc
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserInfoDTO extends BaseDTO {

    private static final long serialVersionUID = 1682062653344339253L;

    /** 用户ID */
    private Long userId;

    /** 手机号 */
    private String mobileNo;

    /** 证件类型 */
    private Integer idType;

    /** 证件号 */
    private String idNo;

    /** 邮箱 */
    private String email;

    /** 账号状态（0：正常，1、注销，2、禁止以任何方式登录） */
    private Integer status;

    /** 域ID */
    private Integer domainId;

    /** 渠道 */
    private String channel;

    /** 渠道包ID */
    private String appId;
}
