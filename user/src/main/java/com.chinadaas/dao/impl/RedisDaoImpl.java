package com.chinadaas.dao.impl;

import com.chinadaas.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * Created by xie on 16/6/22.
 */
public class RedisDaoImpl implements RedisDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> stringOperations;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> objectOperations;

    @Override
    public void saveString(String key, String value) {
        stringOperations.set(key, value);
    }

    @Override
    public String getString(String key) {
        return stringOperations.get(key);
    }

    @Override
    public void saveObject(String key, Object object) {
        objectOperations.set(key,object);
    }

    @Override
    public Object getObject(String key) {
        return objectOperations.get(key);
    }
}
