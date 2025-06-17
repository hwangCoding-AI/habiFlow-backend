package com.habiflow.backend.domain.user;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
