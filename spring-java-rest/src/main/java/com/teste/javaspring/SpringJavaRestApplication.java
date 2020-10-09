package com.teste.javaspring;

import java.io.InputStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.javaspring.model.WrapperProduct;
import com.teste.javaspring.service.ProductService;

@SpringBootApplication
public class SpringJavaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJavaRestApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<WrapperProduct> typeReference = new TypeReference<WrapperProduct>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data_1.json");
			WrapperProduct products = objectMapper.readValue(inputStream, typeReference);
			
			productService.saveAll(products);
		};
	}

}
