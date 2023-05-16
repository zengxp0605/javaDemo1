package com.stan.common.cache.middleware;

import com.stan.common.cache.intf.Cache;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author：zengxp
 */
@Getter
@Setter
public class RedisCacheServiceImpl<K extends Serializable, V extends Serializable>
        implements Cache<K, V> {

    // TODO: 需要依赖redis模块的实现
    private RedisTemplate<K, V> redisTemplate;

    private RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }

    // TODO: 需要考虑redis部署模式。。
    private RedisConnection getRedisServerConnection() {
        return getRedisTemplate().getRequiredConnectionFactory().getConnection();
    }

    @Override
    public void set(K key, V value, int time) {
        getRedisTemplate().opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    @Override
    public void set(K key, V value) {
        getRedisTemplate().opsForValue().set(key, value);
    }

    @Override
    public V get(K key) {
        return getRedisTemplate().opsForValue().get(key);
    }

    @Override
    public void delete(K key) {
        getRedisTemplate().delete(key);
    }

    @Override
    public void expire(K key, int time) {
        getRedisTemplate().expire(key, time, TimeUnit.SECONDS);
    }

    @Override
    public void flushAll() {
        getRedisServerConnection().flushAll();
    }
}
