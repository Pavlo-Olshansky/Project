package com.cooking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({ "com.cooking.app" })
public class DrinkingApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DrinkingApp.class, args);
	}

}
