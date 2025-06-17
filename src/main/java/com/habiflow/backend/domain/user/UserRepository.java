package com.habiflow.backend.domain.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    // username으로 사용자 조회
    Mono<User> findByUsername(String username);

    // 필요하다면 다른 조건도 자연어 메서드 이름으로 확장 가능
    Mono<Boolean> existsByUsername(String username);
}
