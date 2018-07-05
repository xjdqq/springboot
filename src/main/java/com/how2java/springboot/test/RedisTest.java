package com.how2java.springboot.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value = "redis")
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping(value = "/testRedis")
    public String TestRedis(){
        redisTemplate.opsForValue().set("name","yang");
        return redisTemplate.opsForValue().get("name");
    }

}
