package com.teste.javaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.javaspring.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
}
