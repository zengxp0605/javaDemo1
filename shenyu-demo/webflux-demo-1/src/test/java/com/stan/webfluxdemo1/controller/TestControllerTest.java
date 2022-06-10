package com.stan.webfluxdemo1.controller;

import com.stan.webfluxdemo1.shirotest.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author：zengxp
 * @date：2022/4/9 下午4:19
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest {
    @Autowired
    private TestController testController;
    @Autowired
    private ReactiveRedisTemplate reactiveRedisTemplate;

    @Test
    public void test() {
        Mono<Object> test = reactiveRedisTemplate.opsForValue().increment("testsssst2", 1).flatMap(res -> {
            log.info("res: {}", res);
            return Mono.just(res);
        }).switchIfEmpty(Mono.just("Empty...")).doOnError(Exception.class, e -> {
            log.error("发生了 Exception: {}", e);
        }).onErrorReturn("System exception");

        Object block = test.block();
        log.info("sssss: {}", block);

        reactiveRedisTemplate.opsForValue().set("test-k1", 1111).subscribe();
        reactiveRedisTemplate.opsForValue().set("test-k2", 222).subscribe();

        Map<String, Object> map = new HashMap<>();
        map.put("k1", "k1");
        map.put("k2", 100L);
        map.put("k3", UserInfoDTO.builder().userId(1111L).channel("fuyuu").build());
        reactiveRedisTemplate.opsForHash().putAll("test-hash", map).subscribe();
    }

    @Test
    public void getOldSession() throws Exception {
        Set<String> sessionKeys = testController.getOldSession();
    }

    @Test
    public void parseSession() throws Exception {
        String sid = "local:SESSION:e06c7903-d8c6-4d59-bf96-484246df97e7";
        testController.parseSession(sid);
    }
}