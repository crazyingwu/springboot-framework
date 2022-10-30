package com.crazywu.dal.redis.client;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisClientAdapter {
    @Resource
    private RedisTemplate<String, Object> redisClient;

    public void setString(String key, String value) {
        redisClient.opsForValue().set(key, value);
    }

    public String getString(String key) {
        Object o = redisClient.opsForValue().get(key);
        return (String) o;
    }
}
