package com.berkeley.cds.service;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CounterService {

    private RedisTemplate<String, String> redisTemplate;
    private Logger logger;
    private static final String counter="counter";


    @Autowired
    public CounterService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.logger = LoggerFactory.getLogger(CounterService.class);
    }

    public String incrementCounter() {
        if(redisTemplate.opsForValue().get(counter) == null){
            redisTemplate.opsForValue().set(counter, "0");
        }
        redisTemplate.opsForValue().increment(counter);
        return getCounter();
    }

    public String getCounter() {
        return redisTemplate.opsForValue().get(counter);
    }
    
}
