package com.habiflow.backend.config;

import com.habiflow.backend.security.jwt.JwtAuthenticationManager;
import com.habiflow.backend.security.jwt.JwtSecurityContextRepository;
import com.habiflow.backend.security.jwt.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final JwtUtils jwtUtils;

    public SecurityConfig(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        JwtAuthenticationManager authenticationManager = new JwtAuthenticationManager(jwtUtils);
        JwtSecurityContextRepository securityContextRepository = new JwtSecurityContextRepository(authenticationManager);

                return http
            .csrf(csrf -> csrf.disable())   // 람다식으로 disable
            .authenticationManager(authenticationManager)
            .securityContextRepository(securityContextRepository)
            .authorizeExchange(exchange -> exchange
                .pathMatchers("/auth/**").permitAll()
                .anyExchange().authenticated()
            )
            .build();
    }
}
