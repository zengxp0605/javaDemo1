package com.stan.common.cache.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 中间件缓存类别
 *
 * @author：zengxp
 */
@Getter
@AllArgsConstructor
public enum EnumMiddlewareCacheType {
    REDIS("redis", "redis"),
    ;

    private String code;

    private String description;
}
