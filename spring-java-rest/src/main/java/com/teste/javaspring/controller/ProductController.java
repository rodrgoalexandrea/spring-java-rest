package com.teste.javaspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teste.javaspring.model.Product;
import com.teste.javaspring.service.ProductService;

@RestController()
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public @ResponseBody List<Product> findProduct() {

		return productService.findAll();

	}

}
