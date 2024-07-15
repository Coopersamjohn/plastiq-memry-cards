package com.flashcardsetservice.config;

import com.flashcardsetservice.controller.FlashcardSetController;
import io.lettuce.core.ReadFrom;
import io.lettuce.core.RedisURI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.flashcardsetservice.model.FlashcardSet;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.DefaultJedisClientConfig;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

    private static Log log = LogFactory.getLog(RedisConfig.class);

    @Value("${spring.data.redis.host}")
    private String host;
    @Value("${spring.data.redis.port}")
    private Integer port;
    @Value("${spring.data.redis.database}")
    private Integer database;

//    @Bean
//    public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
//        return new SimpleAsyncTaskExecutor();
//    }

//    @Bean
//    FlashcardSet listener() {
//        return new FlashcardSet();
//    }

//    @Bean
//    MessageListenerAdapter messageListenerAdapter(FlashcardSet listener) {
//        return new MessageListenerAdapter(listener, "handleMessage");
//    }

//    @Bean
//    RedisMessageListenerContainer redisMessageListenerContainer(
//            RedisConnectionFactory redisConnectionFactory,
//            MessageListenerAdapter messageListenerAdapter
//    ) {
//        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
//        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, ChannelTopic.of(topicOne));
//        return redisMessageListenerContainer;
//    }

//    /**
//     * Asynchronous Message Listener Container for Redis
//     * container.receive(ChannelTopic.of("channel-name")); to receive live messages
//     * @return
//     */
//    @Bean
//    public ReactiveRedisMessageListenerContainer reactiveRedisMessageListenerContainer() {
//        ReactiveRedisConnectionFactory reactiveRedisConnectionFactory = lettuceConnectionFactory();
//        ReactiveRedisMessageListenerContainer reactiveRedisMessageListenerContainer =
//                new ReactiveRedisMessageListenerContainer(reactiveRedisConnectionFactory);
//        return reactiveRedisMessageListenerContainer;
//    }

//    /**
//     * Factory for Asynchronous Connection to Redis in host/sentinel arrangement
//     * @return
//     */
//    @Bean
//    public ReactiveRedisConnectionFactory lettuceConnectionFactory() {
//        LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
//                .readFrom(ReadFrom.REPLICA_PREFERRED)
//                .apply(RedisURI.builder().withHost(host).withPort(port).withDatabase(database).build())
//                .build();
//
//        RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration(host, port);
////        RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration()
////                .master(host)
////                .sentinel(sentinel1, sentinel1Port)
////                .sentinel(sentinel2, sentinel2Port);
//        return new LettuceConnectionFactory(serverConfig, lettuceClientConfiguration);
//    }

    @Bean
    public RedisConnectionFactory connectionFactory() {
        log.info("Creating JedisConnectionFactory");
        RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration(host, port);
        serverConfig.setDatabase(database);
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(serverConfig);


//        DefaultJedisClientConfig.builder()
//                .ssl(true).sslSocketFactory(sslFactory)
//                .user("default") // use your Redis user. More info https://redis.io/docs/latest/operate/oss_and_stack/management/security/acl/
//                .password("secret!") // use your Redis password
//                .database(2)
//                .build();

        return jedisConnectionFactory;
    }

    @Bean("redisTemplate")
    public RedisTemplate<Long, FlashcardSet> flashcardSetTemplate(RedisConnectionFactory connectionFactory) {
        log.info("Configuring RedisTemplate");
        RedisTemplate<Long, FlashcardSet> template = new RedisTemplate<Long, FlashcardSet>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

}

