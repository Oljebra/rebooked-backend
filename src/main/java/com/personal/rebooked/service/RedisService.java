package com.personal.rebooked.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    // Save value with optional expiration
    public void save(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    // Save value without expiration
    public void save(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // Retrieve value
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // Delete key
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    // Check if key exists
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }
}
