package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.controller")
@EnableJpaRepositories("com.repo")
@EntityScan("com.entity")
@ComponentScan(basePackages = {"com.service.copy", "com.controller", "com.dtos", "com.security"})

public class AyurjeevanAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AyurjeevanAppApplication.class, args);
	}

   
}
