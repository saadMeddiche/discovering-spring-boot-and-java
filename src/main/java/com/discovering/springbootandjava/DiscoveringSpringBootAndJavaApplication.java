package com.discovering.springbootandjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DiscoveringSpringBootAndJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveringSpringBootAndJavaApplication.class, args);
	}

}
