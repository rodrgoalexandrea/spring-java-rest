package com.teste.javaspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teste.javaspring.model.Product;
import com.teste.javaspring.service.ProductService;
import com.teste.javaspring.util.ProductSearchFilter;

@RestController()
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/find")
	public @ResponseBody Page<Product> findProduct(@RequestBody ProductSearchFilter productSearchFilter) {
		Page<Product> pages = productService.findByFilter(productSearchFilter);
		return pages;

	}

}
