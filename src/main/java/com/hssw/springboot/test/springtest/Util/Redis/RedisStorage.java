package com.hssw.springboot.test.springtest.Util.Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisStorage {
    
    private static class RedisStorageInstance{
        private static final RedisStorage INSTANC_REDIS_STORAGE = new RedisStorage();
    }

    private JedisPool jedisPool = null;

    private RedisStorage(){
        if(this.jedisPool ==null){
            this.jedisPool = new JedisPool();
        }
    }

    public static RedisStorage GetInstance(){
        return RedisStorageInstance.INSTANC_REDIS_STORAGE;
    }

    public JedisPool GetPool(){
        return this.jedisPool;
    }

    public Jedis GetResource(){
        return this.jedisPool.getResource();
    }

}