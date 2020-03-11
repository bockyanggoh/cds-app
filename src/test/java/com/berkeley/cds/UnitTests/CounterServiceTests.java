package com.berkeley.cds.UnitTests;

import com.berkeley.cds.service.CounterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.Assert;

import java.util.Random;


public class CounterServiceTests {

    @Mock
    private RedisTemplate<String, String> template;
    @InjectMocks
    private CounterService svc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void incrementCounterSuccessWithNoInitialValue() {
        ValueOperations v = new FakeValueOperations();
        Mockito.when(template.opsForValue()).thenReturn(v);
        Assert.isTrue(svc.incrementCounter().equals(v.get("counter")),"Counter should be 1");
    }

    @Test
    public void incrementCounterSuccessWithPriorValue() {
        ValueOperations v = new FakeValueOperations(true);
        Mockito.when(template.opsForValue()).thenReturn(v);
        Assert.isTrue(svc.incrementCounter().equals(v.get("counter")), "Counter should be 1");
    }
    @Test
    public void incrementCounterSuccessWithRandomValue() {
        int randomValue = new Random().nextInt(150000000);
        ValueOperations v = new FakeValueOperations(randomValue, false);
        Mockito.when(template.opsForValue()).thenReturn(v);
        Assert.isTrue(svc.incrementCounter().equals(String.valueOf(randomValue+1)));

    }

    @Test
    public void getCounterNonExistent() {
        ValueOperations v = new FakeValueOperations(true);
        Mockito.when(template.opsForValue()).thenReturn(v);
        Assert.isNull(svc.getCounter(), "Non existent value should return null");
    }

}
