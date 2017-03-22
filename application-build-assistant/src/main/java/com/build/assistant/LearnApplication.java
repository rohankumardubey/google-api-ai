package com.build.assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.build.*")
@EnableAutoConfiguration
public class LearnApplication {

	public static void main(String[] args) {

		SpringApplication.run(LearnApplication.class, args);
	}
}
