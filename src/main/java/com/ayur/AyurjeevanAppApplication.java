package com.ayur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
    scanBasePackages = {
        "com.ayur.controller",
        "com.ayur.service",
        "com.ayur.security",
        "com.ayur.entity",
        "com.ayur.repo",
        "com.ayur.dtos"
    }
)
@EnableJpaRepositories("com.ayur.repo")
@EntityScan("com.ayur.entity")
public class AyurjeevanAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyurjeevanAppApplication.class, args);
    }
}
