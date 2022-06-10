package com.stan.webfluxdemo1.controller;

import com.alibaba.fastjson.JSON;
import com.stan.webfluxdemo1.shirotest.Base64;
import com.stan.webfluxdemo1.shirotest.MyObjectInputStream;
import com.stan.webfluxdemo1.shirotest.SimpleSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.*;
import java.util.Set;

/**
 * @Author: zengxp
 * @Date: 2022/1/7 10:02
 * @Desc:
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ReactiveRedisTemplate reactiveRedisTemplate;

    public static final String testKey = "test22";

    @RequestMapping("/test")
    public Mono<String> test() throws InterruptedException {
        log.info("test started");
//        redisTemplate.opsForValue().set("test11", "ts-value: " + System.currentTimeMillis());
//        String test = (String) redisTemplate.opsForValue().get("test11");
//        log.info("test value: {}", test);

//
        ReactiveValueOperations<String, String> valueOperations = reactiveRedisTemplate.opsForValue();

//        valueOperations.set(testKey, "sss" + System.currentTimeMillis()).subscribe();
//        Mono<String> test1 = valueOperations.get(testKey);
//        test1.subscribe(str -> log.info("---->{}", str));

        Mono<Boolean> hasKeyMono = reactiveRedisTemplate.hasKey(testKey);
        return hasKeyMono.flatMap(hasKey -> {
            log.info("{}是否存在：{}", testKey, hasKey);
//            if (!hasKey) {
//                return Mono.just("key not exist");
//            }

            return valueOperations.get(testKey).flatMap(str -> {
                log.info("str: {}", str);
//                int a = 1 / 0;
                return Mono.just("aaa-" + str);
            }).switchIfEmpty(Mono.just("Empty...")).doOnError(Exception.class, e -> {
                System.err.println("发生了 Exception");
                e.printStackTrace();
            }).onErrorReturn("System exception");
        });
    }

    @RequestMapping("/save/{val}")
    public Mono<String> save(@PathVariable(required = false) String val) {
        log.info("save started, val={}", val);
        ReactiveValueOperations<String, String> valueOperations = reactiveRedisTemplate.opsForValue();
        return valueOperations.set(testKey, val + "-" + System.currentTimeMillis()).flatMap(res -> {
            log.info("set res: {}", res);
            return Mono.just("set success-" + val);
        });
    }

    @RequestMapping("/del")
    public Mono<String> del() {
        ReactiveValueOperations<String, String> valueOperations = reactiveRedisTemplate.opsForValue();
        return valueOperations.delete(testKey).flatMap(res -> {
            return Mono.just("del key-" + testKey);
        });
    }

    @RequestMapping("/getOldSession")
    public Set<String> getOldSession() throws Exception {
        Set<String> keys = redisTemplate.keys("local:SESSION*");
        System.out.println("getOldSession: " + keys.size());
        for (String key : keys) {
            System.out.println(key);
        }
        return keys;
    }

    @RequestMapping("/test2")
    public Object test2() throws Exception {
        SimpleSession session = new SimpleSession();
        session.setAttribute("userId", 1111L);
        String sid = doCreate(session);

        Object cachedSession = redisTemplate.opsForValue().get(sid);
        SimpleSession decodeSession = bytes2Session(Base64.decode((byte[]) cachedSession));
        System.out.println(decodeSession);
        System.out.println(decodeSession.getAttribute("userId"));
        return decodeSession;
    }

    @RequestMapping("/parseSession")
    public Object parseSession(String sid) throws Exception {
        Object cachedSession = redisTemplate.opsForValue().get(sid);
        log.info("cachedSession: {}", cachedSession);
        SimpleSession decodeSession = bytes2Session(Base64.decode((byte[]) cachedSession));
        log.info("decodeSession: {}", decodeSession);
        log.info("decodeSession.getAttributeKeys : {}", decodeSession.getAttributeKeys());

//        for (Object attributeKey : decodeSession.getAttributeKeys()) {
//            log.info("{}={}", attributeKey, decodeSession.getAttribute(attributeKey));
//        }

        Object userInfo = decodeSession.getAttribute("userInfo");
        log.info("decodeSession userInfo: {}", JSON.toJSONString(userInfo));
        return decodeSession;
    }

    public String doCreate(SimpleSession session) {
        String sessionId = "sessionId:1111:";
        byte[] encode = Base64.encode(session2Bytes(session));
        redisTemplate.opsForValue().set(sessionId, encode);
        return sessionId;
    }


    public byte[] session2Bytes(SimpleSession session) {
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(session);
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public SimpleSession bytes2Session(byte[] bytes) {
        SimpleSession session = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new MyObjectInputStream(byteArrayInputStream);
            session = (SimpleSession) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return session;
    }
}