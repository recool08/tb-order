package com.taotao.order.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@ImportResource(locations={"classpath:dubbo-provider.xml"})	// xml版
@Configuration
public class Config {

	// 配置地址：https://blog.csdn.net/kdpujie/article/details/25818935
    @Bean("jedisPoolConfig")
    public JedisPool jedisPoolConfig() {
//    	JedisPool jedisPool = new JedisPool("172.17.203.90", 6379);
    	
    	JedisPoolConfig config = new JedisPoolConfig();
    	config.setMaxTotal(1000);
    	config.setMaxIdle(200);
    	config.setMaxWaitMillis(2000);
    	config.setTestOnBorrow(true);
    	
    	JedisPool jedisPool = new JedisPool(config, "172.17.203.90", 6379, 2000, "123456");
    	
//    	jedisPool.initPool(config, null);
    	
        return jedisPool;
    }
}
