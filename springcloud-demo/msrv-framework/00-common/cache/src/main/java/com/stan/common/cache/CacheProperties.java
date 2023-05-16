package com.stan.common.cache;

import com.stan.common.cache.enums.EnumMemoryCacheType;
import com.stan.common.cache.enums.EnumMiddlewareCacheType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * @author：zengxp
 */
@Data
@ConfigurationProperties("msrv.cache")
public class CacheProperties {
    /**
     * 中间件缓存类型
     */
    private String middlewareCacheType = EnumMiddlewareCacheType.REDIS.getCode();

    /**
     * 内存缓存类型
     */
    private String memoryCacheType = EnumMemoryCacheType.GUAVA.getCode();

    // guava做缓存时需要下面的配置
    private GuavaCacheConfiguration guava = new GuavaCacheConfiguration();

    @Data
    public static class GuavaCacheConfiguration {
        /**
         * 缓存大小
         */
        private long size;

        /**
         * 写后多久超时
         */
        private Duration expireAfterWrite;

        /**
         * 访问后多久超时
         */
        private Duration expireAfterAccess;
    }
}
