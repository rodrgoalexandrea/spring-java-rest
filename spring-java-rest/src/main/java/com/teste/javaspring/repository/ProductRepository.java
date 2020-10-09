package com.teste.javaspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teste.javaspring.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product p where p.product = :productName")
	public Page<Product> findByName(@Param("productName") String productName, Pageable pageable);
	
}
