package com.habiflow.backend.api;

import com.habiflow.backend.domain.user.User;
import com.habiflow.backend.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{username}")
    public Mono<User> getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
