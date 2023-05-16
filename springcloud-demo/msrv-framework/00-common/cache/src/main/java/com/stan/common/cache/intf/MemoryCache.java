package com.stan.common.cache.intf;

import java.io.Serializable;

/**
 * 内存缓存接口
 *
 * @author：zengxp
 */
public interface MemoryCache<K extends Serializable, V extends Serializable>
        extends ICache<K, V> {
}
