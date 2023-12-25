package com.als;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.als.repository")
public class AlsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlsApplication.class, args);
	}

}
