package com.stan.common.cache.intf;

import com.stan.common.cache.exception.CacheException;

import java.io.Serializable;

/**
 * 缓存抽象接口
 *
 * @author：zengxp
 */
public interface ICache<K extends Serializable, V extends Serializable> {

    void set(K key, V value, int time);

    void set(K key, V value);

    V get(K key);

    void delete(K key);

    void expire(K key, int time);

    default void flushAll() {
        throw new CacheException("UN_SUPPORT_CACHE");
    }

    /**
     * ...TODO: 定义其他接口
     */
}
