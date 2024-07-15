package com.flashcardservice.config;

import io.lettuce.core.ReadFrom;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.ReactiveRedisMessageListenerContainer;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import com.flashcardservice.model.Flashcard;

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
//    @Value("${spring.redis.sentinel1}")
//    private String sentinel1;
//	@Value("${spring.redis.sentinel1Port}")
//    private Integer sentinel1Port;
//	@Value("${spring.redis.sentinel2}")
//    private String sentinel2;
//	@Value("${spring.redis.sentinel2Port}")
//    private Integer sentinel2Port;
//	@Value("${spring.redis.topic.one}")
//	private String topicOne;

//	@Bean
//	public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
//		return new SimpleAsyncTaskExecutor();
//	}
//
//	@Bean
//	Flashcard listener() {
//		return new Flashcard();
//	}
//
//	@Bean
//	MessageListenerAdapter messageListenerAdapter(Flashcard listener) {
//		return new MessageListenerAdapter(listener, "handleMessage");
//	}
//
//	@Bean
//	RedisMessageListenerContainer redisMessageListenerContainer(
//			RedisConnectionFactory redisConnectionFactory,
//			MessageListenerAdapter messageListenerAdapter
//	) {
//		RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//		redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
//		redisMessageListenerContainer.addMessageListener(messageListenerAdapter, ChannelTopic.of(topicOne));
//		return redisMessageListenerContainer;
//	}

//	/**
//	 * Asynchronous Message Listener Container for Redis
//	 * container.receive(ChannelTopic.of("channel-name")); to receive live messages
//	 * @return
//	 */
//	@Bean
//	public ReactiveRedisMessageListenerContainer reactiveRedisMessageListenerContainer() {
//		ReactiveRedisConnectionFactory reactiveRedisConnectionFactory = lettuceConnectionFactory();
//		ReactiveRedisMessageListenerContainer reactiveRedisMessageListenerContainer =
//				new ReactiveRedisMessageListenerContainer(reactiveRedisConnectionFactory);
//		return reactiveRedisMessageListenerContainer;
//	}

	/**
	 * Factory for Asynchronous Connection to Redis in host/sentinel arrangement
	 * @return
	 */
	@Bean
	public ReactiveRedisConnectionFactory lettuceConnectionFactory() {
		LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
				.readFrom(ReadFrom.REPLICA_PREFERRED)
				.build();

		RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration(host, port);
//		RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration()
//				.master(host)
//				.sentinel(sentinel1, sentinel1Port)
//				.sentinel(sentinel2, sentinel2Port);
		return new LettuceConnectionFactory(serverConfig, lettuceClientConfiguration);
	}

//	/**
//	 * Standard template for Redis with ReactiveRedisConnectionFactory and
//	 * Jackson2JsonRedisSerializer, by Flashcard Domain
//	 * @param connectionFactory
//	 * @return
//	 */
//	@Bean
//	public ReactiveRedisTemplate<Long, Flashcard> flashcardTemplate(ReactiveRedisConnectionFactory connectionFactory) {
//		ReactiveRedisTemplate<Long, Flashcard> template = new ReactiveRedisTemplate<Long, Flashcard>(
//				connectionFactory,
//				RedisSerializationContext.fromSerializer(new Jackson2JsonRedisSerializer(Flashcard.class))
//		);
//	    return template;
//	}

	@Bean
	public RedisConnectionFactory connectionFactory() {
		log.info("Creating JedisConnectionFactory");
		RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration(host, port);
		serverConfig.setDatabase(database);
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(serverConfig);

		return jedisConnectionFactory;
	}

	@Bean
	public RedisTemplate<Long, Flashcard> flashcardSetTemplate(RedisConnectionFactory connectionFactory) {
		log.info("Configuring RedisTemplate");
		RedisTemplate<Long, Flashcard> template = new RedisTemplate<Long, Flashcard>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}

}
