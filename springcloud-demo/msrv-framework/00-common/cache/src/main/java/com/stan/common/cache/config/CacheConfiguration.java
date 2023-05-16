package com.stan.common.cache.config;

import com.google.common.cache.CacheBuilder;
import com.stan.common.cache.CacheProperties;
import com.stan.common.cache.intf.Cache;
import com.stan.common.cache.intf.MemoryCache;
import com.stan.common.cache.memory.GuavaCacheServiceImpl;
import com.stan.common.cache.middleware.RedisCacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author：zengxp
 */
@Configuration
@EnableConfigurationProperties(CacheProperties.class)
public class CacheConfiguration {

    @Autowired
    private CacheProperties cacheProperties;

    @Bean
    @ConditionalOnProperty(prefix = "msrv.cache", value = "middleware-cache-type", havingValue = "redis",
            matchIfMissing = true)
    public Cache redisMiddlewareCache(RedisTemplate redisTemplate) {
        RedisCacheServiceImpl cache = new RedisCacheServiceImpl();
        cache.setRedisTemplate(redisTemplate);
        return cache;
    }

    @Bean
    @ConditionalOnProperty(prefix = "msrv.cache", value = "memory-cache-type", havingValue = "guava",
            matchIfMissing = true)
    public MemoryCache guavaMemoryCache() {
        GuavaCacheServiceImpl<Serializable, Serializable> guavaCacheService = new GuavaCacheServiceImpl();
        com.google.common.cache.Cache<Serializable, Serializable> cache = getGuavaCache();
        guavaCacheService.setKvCache(cache);
        return guavaCacheService;
    }

    /**
     * 构造guava cache
     *
     * @return
     */
    private com.google.common.cache.Cache<Serializable, Serializable> getGuavaCache() {
        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder();
        CacheProperties.GuavaCacheConfiguration guava = cacheProperties.getGuava();
        cacheBuilder.maximumSize(guava.getSize());

        if (guava.getExpireAfterAccess() != null) {
            cacheBuilder.expireAfterAccess(guava.getExpireAfterAccess().toMillis(),
                    TimeUnit.MILLISECONDS);
        }

        if (guava.getExpireAfterWrite() != null) {
            cacheBuilder.expireAfterWrite(guava.getExpireAfterWrite().toMillis(),
                    TimeUnit.MILLISECONDS);
        }

        return cacheBuilder.build();
    }
}
