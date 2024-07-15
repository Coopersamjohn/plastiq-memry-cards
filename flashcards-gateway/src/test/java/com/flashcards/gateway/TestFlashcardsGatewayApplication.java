package com.flashcards.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestFlashcardsGatewayApplication {

//	@Bean
//	@ServiceConnection
//	KafkaContainer kafkaContainer() {
//		return new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));
//	}
//
//	@Bean
//	@ServiceConnection(name = "redis")
//	GenericContainer<?> redisContainer() {
//		return new GenericContainer<>(DockerImageName.parse("redis:latest")).withExposedPorts(6379);
//	}

	public static void main(String[] args) {
		SpringApplication.from(FlashcardsGatewayApplication::main).with(TestFlashcardsGatewayApplication.class).run(args);
	}

}
