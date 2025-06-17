package com.habiflow.backend.security.jwt;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import reactor.core.publisher.Mono;

import java.util.List;

public class JwtAuthenticationManager implements ReactiveAuthenticationManager {

    private final JwtUtils jwtUtils;

    public JwtAuthenticationManager(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getCredentials().toString();
        String username;

        try {
            username = jwtUtils.getUsernameFromToken(authToken);
        } catch (Exception e) {
            username = null;
        }

        if (username != null && jwtUtils.isTokenValid(authToken, username)) {
            // 여기서 권한을 부여하거나 UserDetailsService로 권한 추가도 가능
            List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

            Authentication auth = new UsernamePasswordAuthenticationToken(username, null, authorities);
            return Mono.just(auth);
        } else {
            return Mono.empty();
        }
    }
}
