package com.teste.javaspring.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.javaspring.model.Product;
import com.teste.javaspring.model.WrapperProduct;
import com.teste.javaspring.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public void saveAll(WrapperProduct product) {
		productRepository.saveAll(product.getData());
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public void initDataBase() {

		List<String> files = Arrays.asList("/json/data_1.json", "/json/data_2.json", "/json/data_3.json",
				"/json/data_4.json");

		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<WrapperProduct> typeReference = new TypeReference<WrapperProduct>() {
		};

		files.forEach(file -> {
			InputStream inputStream = null;
			try {
				inputStream = TypeReference.class.getResourceAsStream(file);
				WrapperProduct product = objectMapper.readValue(inputStream, typeReference);
				List<Product> products = product.getData().parallelStream().distinct().collect(Collectors.toList());

				productRepository.saveAll(products);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO: handle exception
				}

			}

		});

	}

	
	
}
