package com.teste.javaspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.teste.javaspring.service.ProductService;

@SpringBootApplication
public class SpringJavaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJavaRestApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.initDataBase();
		};
	}

}
