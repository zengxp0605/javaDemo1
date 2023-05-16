package com.stan.common.cache.memory;

import com.stan.common.cache.exception.CacheException;
import com.stan.common.cache.intf.Cache;
import com.stan.common.cache.intf.MemoryCache;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author：zengxp
 */
@Getter
@Setter
public class GuavaCacheServiceImpl<K extends Serializable, V extends Serializable>
        implements MemoryCache<K, V> {

    private com.google.common.cache.Cache<K, V> kvCache;

    @Override
    public void set(K key, V value, int time) {
        throw new CacheException("UN_SUPPORT_CACHE");
    }

    @Override
    public void set(K key, V value) {
        kvCache.put(key, value);
    }

    @Override
    public V get(K key) {
        return kvCache.getIfPresent(key);
    }

    @Override
    public void delete(K key) {
        kvCache.invalidate(key);
    }

    @Override
    public void expire(K key, int time) {
        throw new CacheException("UN_SUPPORT_CACHE");
    }
}
