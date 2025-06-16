package com.habiflow.backend.domain.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String role;

    // Getters and setters omitted for brevity
}
