//package com.flashcardservice.service;
//
//import static org.mockito.Mockito.CALLS_REAL_METHODS;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;
//
//@SpringBootTest
//@AutoConfigureWebTestClient
//public class FlashcardServiceTest {
//
//    @Value("${spring.redis.host}")
//    private String redisHost;
//    @Value("${spring.redis.port}")
//    private Integer redisPort;
//
//	@Autowired
//	private WebTestClient webTestClient;
//
//	@Test
//	void corsTest() {
//		ResponseSpec response = webTestClient.get()
//				.uri("http://" + this.redisHost + ":" + this.redisPort).exchange();
//		response.expectStatus();
//	}
//
//	@Test
//	void givenRequest_whenFindAll_thenReceiveAllFlashcardSets() {
//
//	}
//
//}
