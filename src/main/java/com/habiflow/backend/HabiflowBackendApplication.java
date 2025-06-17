package com.habiflow.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.habiflow")
public class HabiflowBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(HabiflowBackendApplication.class, args);
    }
}
