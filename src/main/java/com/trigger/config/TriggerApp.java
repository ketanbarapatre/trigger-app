package com.trigger.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.trigger.*")
public class TriggerApp {
	
	public static void main(String[] args) {
		SpringApplication.run(TriggerApp.class, args);
	}
		
}
