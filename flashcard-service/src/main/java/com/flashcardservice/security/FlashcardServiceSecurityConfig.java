//package com.flashcardservice.security;
//
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.ReactiveRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//
//import com.flashcardservice.model.FlashcardSet;
//
//@Configuration
//@EnableWebFluxSecurity
//@EnableMethodSecurity
//public class FlashcardServiceSecurityConfig {
//
//	@Bean
//	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//		http.authorizeExchange()
////		.pathMatchers(HttpMethod.POST, "/saveFlashcardSet").hasRole("ADMIN")
//		.pathMatchers("/**").permitAll()
//		.and()
//		.httpBasic();
//		return http.build();
//	}
//
//	@Bean
//	public CorsConfigurationSource corsConfigurationSource() {
//	    CorsConfiguration configuration = new CorsConfiguration();
//	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:8100", "http://localhost:4200/"));
//	    configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "OPTIONS"));
//	    configuration.addAllowedHeader("*");
////	    configuration.setAllowCredentials(true);
//	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    source.registerCorsConfiguration("/**", configuration);
//	    return source;
//	}
//
//}
