//package com.flashcards.gateway.config;
//
//import io.jsonwebtoken.Jwts;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
//import org.springframework.security.web.session.HttpSessionEventPublisher;
//import org.springframework.web.reactive.config.EnableWebFlux;
//
//import javax.crypto.SecretKey;
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZonedDateTime;
//import java.time.temporal.ChronoUnit;
//import java.time.temporal.TemporalUnit;
//import java.util.Date;
//
//@Configuration
//@EnableWebFluxSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain springSecurityWebFilterChain(
//            ServerHttpSecurity httpSecurity
//    ) {
////        Customizer<ServerHttpSecurity.CsrfSpec> csrfSpecCustomizer = csrfSpec -> csrfSpec
////                .requireCsrfProtectionMatcher().csrfTokenRepository().accessDeniedHandler().csrfTokenRequestHandler().disable()
////        Customizer<ServerHttpSecurity.AuthorizeExchangeSpec> authorizeExchangeCustomizer = new Customizer<ServerHttpSecurity.AuthorizeExchangeSpec>() {
////            @Override
////            public void customize(ServerHttpSecurity.AuthorizeExchangeSpec authorizeExchangeSpec) {
////
////            }
////        }
////        httpSecurity
//////                .csrf(csrfSpecCustomizer)
////                .sessionManagement((sessions) ->)
////                .authorizeExchange(exchanges -> exchanges
////                        .pathMatchers("/**").permitAll()
////                        .anyExchange().authenticated())
////                .authorizeExchange(exchanges -> exchanges
////                        .pathMatchers(HttpMethod.POST, "flashcards")
////                        .hasRole("SUBSCRIBED"))
////                .httpBasic(Customizer.withDefaults());
//        return httpSecurity.build();
//    }
//
//    public String buildJwtToken(String subject, String issuer, String notBefore) {
//        Date issuedAt = Date.from(Instant.now());
//        Date expiration = Date.from(Instant.now().plus(6, ChronoUnit.HOURS));
//        SecretKey key = Jwts.SIG.HS256.key().build();
//        return Jwts.builder()
//                .subject(subject)
//                .issuer(issuer)
//                .expiration(expiration)
//                .notBefore(issuedAt)
//                .issuedAt(issuedAt)
//                .signWith(key).compact();
//    }
//}
