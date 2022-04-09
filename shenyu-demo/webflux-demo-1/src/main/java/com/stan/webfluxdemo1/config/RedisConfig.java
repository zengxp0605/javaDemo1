package com.stan.webfluxdemo1.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author zengxp
 * @date: 2022/1/5 20:25
 */
// TODO: 需要换成连接池
@Configuration
public class RedisConfig {

    @Value("${spring.redis.node}")
    private String redisNode;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        String[] strings = redisNode.split(":");
        String host = strings[0];
        String port = strings[1];
        RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration();
        redisConfiguration.setDatabase(0);
        redisConfiguration.setHostName(host);
        redisConfiguration.setPort(Integer.valueOf(port));
        redisConfiguration.setPassword(password);
        return new LettuceConnectionFactory(redisConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);

        GenericFastJsonRedisSerializer fastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);

        return redisTemplate;
    }

//    @Bean
//    public ReactiveRedisTemplate<String, String> reactiveRedisTemplate(ReactiveRedisConnectionFactory redisConnectionFactory) {
//        ReactiveRedisTemplate<String, String> reactiveRedisTemplate = new ReactiveRedisTemplate<String, String>(redisConnectionFactory, RedisSerializationContext.string());
//        return reactiveRedisTemplate;
//    }

    @Bean
    public ReactiveRedisTemplate reactiveRedisTemplate(ReactiveRedisConnectionFactory connectionFactory) {
        RedisSerializationContext.SerializationPair<String> stringSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer.UTF_8);
        RedisSerializationContext.SerializationPair<Object> objectSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json());
        RedisSerializationContext.RedisSerializationContextBuilder builder =
                RedisSerializationContext.newSerializationContext();
        builder.key(stringSerializationPair);

        builder.value(objectSerializationPair);

        builder.hashKey(stringSerializationPair);
        builder.hashValue(objectSerializationPair);

        builder.string(objectSerializationPair);

        RedisSerializationContext build = builder.build();

        return new ReactiveRedisTemplate(connectionFactory, build);
    }
}
