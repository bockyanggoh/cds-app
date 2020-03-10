package com.berkeley.cds.UnitTests;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
public class FakeValueOperations implements ValueOperations<String, String> {

    public FakeValueOperations(boolean setNull) {
        this.setNull = setNull;
    }

    private int i = 0;
    private boolean setNull;
    @SneakyThrows
    @Override
    public void set(String s, String s2) {
        if(s == "counter") return;
        throw new Exception("Fake VOps supports key:counter only.");
    }

    @Override
    public void set(String s, String s2, long l, TimeUnit timeUnit) {

    }

    @Override
    public Boolean setIfAbsent(String s, String s2) {
        return null;
    }

    @Override
    public Boolean setIfAbsent(String s, String s2, long l, TimeUnit timeUnit) {
        return null;
    }

    @Override
    public Boolean setIfPresent(String s, String s2) {
        return null;
    }

    @Override
    public Boolean setIfPresent(String s, String s2, long l, TimeUnit timeUnit) {
        return null;
    }

    @Override
    public void multiSet(Map<? extends String, ? extends String> map) {

    }

    @Override
    public Boolean multiSetIfAbsent(Map<? extends String, ? extends String> map) {
        return null;
    }

    @Override
    public String get(Object o) {
        if(this.setNull){
            this.setNull = false;
            return null;
        }
        return String.valueOf(i);
    }

    @Override
    public String getAndSet(String s, String s2) {
        return null;
    }

    @Override
    public List<String> multiGet(Collection<String> collection) {
        return null;
    }

    @Override
    public Long increment(String s) {
        i++;
        return 1L;
    }

    @Override
    public Long increment(String s, long l) {
        i++;
        return 1L;
    }

    @Override
    public Double increment(String s, double v) {
        return null;
    }

    @Override
    public Long decrement(String s) {
        return null;
    }

    @Override
    public Long decrement(String s, long l) {
        return null;
    }

    @Override
    public Integer append(String s, String s2) {
        return null;
    }

    @Override
    public String get(String s, long l, long l1) {
        return null;
    }

    @Override
    public void set(String s, String s2, long l) {

    }

    @Override
    public Long size(String s) {
        return null;
    }

    @Override
    public Boolean setBit(String s, long l, boolean b) {
        return null;
    }

    @Override
    public Boolean getBit(String s, long l) {
        return null;
    }

    @Override
    public List<Long> bitField(String s, BitFieldSubCommands bitFieldSubCommands) {
        return null;
    }

    @Override
    public RedisOperations<String, String> getOperations() {
        return null;
    }
}
