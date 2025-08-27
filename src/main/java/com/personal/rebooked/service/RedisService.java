package com.personal.rebooked.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public void save(String key, Object value) {
        Gson gson = new Gson();
        String json = gson.toJson(value);
        redisTemplate.opsForValue().set(key, json);
    }

    public Object get(String key) {
        Gson gson = new Gson();
        String result = redisTemplate.opsForValue().get(key);
        return gson.fromJson(result, Object.class);
    }
}
