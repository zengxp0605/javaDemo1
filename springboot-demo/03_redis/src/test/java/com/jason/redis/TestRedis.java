package com.jason.redis;


import com.jason.redis.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception{
        String key = "aaa";
        stringRedisTemplate.opsForValue().set(key, "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get(key));
    }

    @Test
    public void testObj() throws Exception{
        User user = new User("zeng@163,com", "zxp", "123456", "xiao", "123");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.tmp1", user);
        operations.set("com.temp33.f", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("com.neo.f");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}
