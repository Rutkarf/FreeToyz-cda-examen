package com.api.freetoyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class FreetoyzApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreetoyzApplication.class, args);
	}

}
