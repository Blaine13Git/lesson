package com.study.lion.lesson.aboutRedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * JedisPool初始化配置
 */
public class JedisPoolConfig extends GenericObjectPoolConfig {
    public JedisPoolConfig() {
        setTestWhileIdle(true);
        setMinEvictableIdleTimeMillis(60000);
        setTimeBetweenEvictionRunsMillis(30000);
        setNumTestsPerEvictionRun(-1);
    }
}
