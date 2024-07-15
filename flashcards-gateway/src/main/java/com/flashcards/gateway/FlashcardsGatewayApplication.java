package com.flashcards.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class FlashcardsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashcardsGatewayApplication.class, args);
	}

}
