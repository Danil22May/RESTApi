package com.daniil.supportapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupportappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportappApplication.class, args);
		System.out.println("Server is OK");
	}

}
