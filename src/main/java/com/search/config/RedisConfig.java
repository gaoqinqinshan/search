package com.search.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.Duration;

@Configuration
public class RedisConfig {
    //redis数据库索引（默认为0（0-15）
    @Value("${spring.redis.database.db0}")
    private int db0;

    @Value("${spring.redis.database.db1}")
    private int db1;

    //redis服务器地址
    @Value("${spring.redis.host}")
    private String host;

    //redis账户密码
    @Value("${spring.redis.password}")
    private String password;

    //redis服务器连接端口
    @Value("${spring.redis.port}")
    private int port;

    //连接超时时间（以毫秒为单位）
    @Value("${spring.redis.timeout}")
    private int timeout;

    //redis连接池最大空闲连接
    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    //redis连接池最大连接数（使用负数则代表没有连接数没有限制）
    @Value("${spring.redis.pool.max-active}")
    private int maxActive;

    //redis连接池最小空闲连接
    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    //redis连接池最大阻塞等待时间
    @Value("${spring.redis.pool.max-wait}")
    private long maxWait;

    @Bean
    public GenericObjectPoolConfig getPoolConfig() {
        // 配置redis连接池
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWait);
        return poolConfig;
    }

    @Bean(name = "redisTemplate0")
    public StringRedisTemplate getRedisTemplate7() {
        return getStringRedisTemplate(db0);
    }

    @Bean(name = "redisTemplate1")
    public StringRedisTemplate getRedisTemplate5() {
        return getStringRedisTemplate(db1);
    }

    private StringRedisTemplate getStringRedisTemplate(int database) {
        // 构建工厂对象
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(host);
        config.setPort(port);
        config.setPassword(password);
        //config.setPassword(RedisPassword.of(password));
        LettucePoolingClientConfiguration clientConfig = LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofSeconds(timeout))
                .poolConfig(getPoolConfig())
                .build();
        LettuceConnectionFactory factory = new LettuceConnectionFactory(config, clientConfig);
        // 设置使用的redis数据库
        factory.setDatabase(database);
        // 重新初始化工厂
        factory.afterPropertiesSet();
        return new StringRedisTemplate(factory);
    }
}
