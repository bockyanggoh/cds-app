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
        Assert.isTrue(svc.incrementCounter().equals(v.get("counter")));
    }

    @Test
    public void incrementCounterSuccessWithPriorValue() {
        ValueOperations v = new FakeValueOperations(true);
        Mockito.when(template.opsForValue()).thenReturn(v);
        svc.incrementCounter().equals(v.get("counter"));
    }
}
