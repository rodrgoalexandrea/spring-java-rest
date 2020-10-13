package com.teste.javaspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teste.javaspring.model.Product;
import com.teste.javaspring.service.ProductService;
import com.teste.javaspring.util.ProductSearchFilter;

@RestController()
@RequestMapping(value = "/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/find")
	public @ResponseStatus ResponseEntity<Page<Product>> findProduct(@RequestBody ProductSearchFilter productSearchFilter) {
		try {
			Page<Product> retorno = productService.findByFilter(productSearchFilter);
			if (retorno != null) {
				return ResponseEntity.ok(retorno);
			} else {
				return ResponseEntity.notFound().build();
			}
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/reimportData")
	public void reinitializeDataBase() {
		productService.deleteAll();
		productService.initDataBase();
	}

}
