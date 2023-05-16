package com.stan.common.cache.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author：zengxp
 */
@Getter
@Setter
@AllArgsConstructor
public class CacheException extends RuntimeException {

    private String code;
}
