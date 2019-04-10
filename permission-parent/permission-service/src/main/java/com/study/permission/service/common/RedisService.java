package com.study.permission.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author caad
 * @date: Create in 17:34 2019/4/10
 */
@Service
public class RedisService {

    // 在构造器中获取redisTemplate实例, key(not hasObjectey) 默认使用String类型
    private final RedisTemplate redisTemplate;
    // 在构造器中通过redisTemplate的工厂方法实例化操作对象
    private final HashOperations hashOperations;
    private final ListOperations listOperations;
    private final ZSetOperations zSetOperations;
    private final SetOperations setOperations;
    private final ValueOperations valueOperations;

    @Autowired
    public RedisService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.listOperations = redisTemplate.opsForList();
        this.zSetOperations = redisTemplate.opsForZSet();
        this.setOperations = redisTemplate.opsForSet();
        this.valueOperations = redisTemplate.opsForValue();
    }

    public void hashPut(String key, Object hasObjectey, Object value) {
        hashOperations.put(key, hasObjectey, value);
    }

    public Map hashFindAll(String key) {
        return hashOperations.entries(key);
    }

    public Object hashGet(String key, Object hasObjectey) {
        return hashOperations.get(key, hasObjectey);
    }

    public void hashRemove(String key, Object hasObjectey) {
        hashOperations.delete(key, hasObjectey);
    }

    public Long listPush(String key, Object value) {
        return listOperations.rightPush(key, value);
    }

    public Long listUnshift(String key, Object value) {
        return listOperations.leftPush(key, value);
    }

    public List listFindAll(String key) {
        if (!redisTemplate.hasKey(key)) {
            return null;
        }
        return listOperations.range(key, 0, listOperations.size(key));
    }

    public Object listLPop(String key) {
        return listOperations.leftPop(key);
    }

    public void setValue(String key, Object value) {
        valueOperations.set(key, value);
    }

    public void setValue(String key, Object value, long timeout) {
        ValueOperations<String, Object>  vo = redisTemplate.opsForValue();
        vo.set(key, value, timeout, TimeUnit.MILLISECONDS);
    }


    public Object getValue(String key) {
        return valueOperations.get(key);
    }

    public void remove(String key) {
        redisTemplate.delete(key);
    }

    public boolean expire(String key, long timeout, TimeUnit timeUnit) {
        return redisTemplate.expire(key, timeout, timeUnit);
    }
}
