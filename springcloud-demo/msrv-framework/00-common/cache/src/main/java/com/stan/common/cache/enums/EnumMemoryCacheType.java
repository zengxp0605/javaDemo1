package com.stan.common.cache.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 内存缓存类别
 *
 * @author：zengxp
 */
@Getter
@AllArgsConstructor
public enum EnumMemoryCacheType {
    GUAVA("guava", "guava"),
    ;

    private String code;

    private String description;
}
