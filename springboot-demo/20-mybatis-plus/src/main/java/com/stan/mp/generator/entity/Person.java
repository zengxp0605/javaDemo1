package com.stan.mp.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 家庭成员表
 * </p>
 *
 * @author Jason
 * @since 2021-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 家庭成员ID
     */
    private Long personId;

    /**
     * 真实姓名，必须唯一
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 佩戴人手机号
     */
    private String mobileNo;

    /**
     * 佩戴人手机号有效性，1：有效，0无效
     */
    private Integer mobileValid;

    /**
     * 是否本人：1：是、0：否
     */
    private Integer relationType;

    /**
     * 关系昵称
     */
    private String relationNickname;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 证件号
     */
    private String idNo;

    /**
     * 用户性别0：男 1：女
     */
    private Integer gender;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 身高（单位：cm）
     */
    private Integer height;

    /**
     * 体重（单位：kg）
     */
    private Float weight;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreated;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 是否删除：1：已删除、0：未删除
     */
    private Integer isDeleted;

    /**
     * 乐观锁版本
     */
    private Integer version;


}
