package com.teste.javaspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
}
