package com.habiflow.backend.api;

import com.habiflow.backend.domain.auth.AuthService;
import com.habiflow.backend.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(@RequestBody User user) {
        return authService.login(user)
            .map(token -> ResponseEntity.ok(token));
    }
}