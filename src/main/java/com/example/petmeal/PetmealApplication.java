package com.example.petmeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class PetmealApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetmealApplication.class, args);
	}

}
