package com.apiboard.apiboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ApiboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiboardApplication.class, args);
	}

}
