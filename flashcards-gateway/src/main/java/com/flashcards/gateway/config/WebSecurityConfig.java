package com.flashcards.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.ServerWebExchangeDelegatingServerAccessDeniedHandler;
import org.springframework.security.web.server.csrf.ServerCsrfTokenRequestAttributeHandler;
import org.springframework.security.web.server.csrf.WebSessionServerCsrfTokenRepository;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableReactiveMethodSecurity
@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityWebFilterChain(
            ServerHttpSecurity httpSecurity,
            CorsConfigurationSource corsConfigurationSource
    ) {
        Customizer<ServerHttpSecurity.CsrfSpec> csrfSpecCustomizer = csrfSpec -> csrfSpec
                .requireCsrfProtectionMatcher((ServerWebExchangeMatcher) ServerWebExchangeMatcher.MatchResult.match())
                .csrfTokenRepository(new WebSessionServerCsrfTokenRepository())
                .accessDeniedHandler(new ServerWebExchangeDelegatingServerAccessDeniedHandler())
                .csrfTokenRequestHandler(new ServerCsrfTokenRequestAttributeHandler()).disable();
        Customizer<ServerHttpSecurity.CorsSpec> corsSpecCustomizer = corsSpec -> corsSpec
                .configurationSource(corsConfigurationSource);
//        Customizer<ServerHttpSecurity.AuthorizeExchangeSpec> authorizeExchangeCustomizer = new Customizer<ServerHttpSecurity.AuthorizeExchangeSpec>() {
//            @Override
//            public void customize(ServerHttpSecurity.AuthorizeExchangeSpec authorizeExchangeSpec) {
//
//            }
//        };
        httpSecurity
                .csrf(csrfSpecCustomizer)
                .cors(corsSpecCustomizer)
                .sessionManagement((sessions) -> sessions.concurrentSessions(concurrentSessionsSpec -> {}))
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/**").permitAll()
                        .anyExchange().authenticated())
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/**", "/**")
                        .hasRole("SUBSCRIBED"))
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
//
//        httpSecurity.cors(cors -> cors.disable())
//                .securityMatcher(new PathPatternParserServerWebExchangeMatcher("/**"))
//                .authorizeExchange((authorizeExchangeSpec -> {}));
//
//        return httpSecurity.build();
//    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.applyPermitDefaultValues();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Requestor-Type"));
        corsConfiguration.setExposedHeaders(Arrays.asList("X-Get-Header"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return urlBasedCorsConfigurationSource;
    }

//    @Bean
//    public CorsWebFilter corsWebFilter() {
//        return new CorsWebFilter(corsConfigurationSource());
//    }

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
}
