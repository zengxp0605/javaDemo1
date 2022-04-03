package com.stan.mp.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 渠道详情表
 * </p>
 *
 * @author Jason
 * @since 2021-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ChannelDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 域ID
     */
    private Integer domainId;

    /**
     * 渠道描述
     */
    private String channelDesc;

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
