package com.habiflow.backend.domain.auth;

import com.habiflow.backend.domain.user.User;
import com.habiflow.backend.domain.user.UserRepository;
import com.habiflow.backend.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    public Mono<String> login(User user) {
        return userRepository.findByUsername(user.getUsername())
            .switchIfEmpty(Mono.error(new RuntimeException("사용자를 찾을 수 없습니다.")))
            .flatMap(u -> {
                // 실제 환경에선 비밀번호는 BCrypt 등으로 검증해야 함
                if (!u.getPassword().equals(user.getPassword())) {
                    return Mono.error(new RuntimeException("비밀번호가 일치하지 않습니다."));
                }
                String token = jwtUtils.generateToken(u.getUsername());
                return Mono.just(token);
            });
    }
}
