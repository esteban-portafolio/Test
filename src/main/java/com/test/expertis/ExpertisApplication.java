package com.test.expertis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@SpringBootApplication
public class ExpertisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpertisApplication.class, args);
	}

}
