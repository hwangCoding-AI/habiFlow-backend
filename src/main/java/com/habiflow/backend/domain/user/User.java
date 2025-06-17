package com.habiflow.backend.domain.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("users")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String role;

    // Getters and setters omitted for brevity
}
