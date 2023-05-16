package com.stan.common.cache.intf;

import java.io.Serializable;

/**
 * 中间件缓存接口
 *
 * @author：zengxp
 */
public interface Cache<K extends Serializable, V extends Serializable>
        extends ICache<K, V> {
}
