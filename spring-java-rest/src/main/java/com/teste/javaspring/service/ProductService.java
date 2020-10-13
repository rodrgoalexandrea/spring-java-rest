package com.teste.javaspring.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.javaspring.enums.ProductSearchType;
import com.teste.javaspring.model.Product;
import com.teste.javaspring.model.WrapperProduct;
import com.teste.javaspring.repository.ProductRepository;
import com.teste.javaspring.util.ProductSearchFilter;

@Service
public class ProductService {

	private static final String MSG_ILLEGAL_ARGUMENT = "Invalid search type";

	@Autowired
	ProductRepository productRepository;

	public Page<Product> findByFilter(ProductSearchFilter productSearchFilter) {
		try {
		
			Pageable pageable = PageRequest.of(productSearchFilter.getPageNumber(), productSearchFilter.getPageSize(), Sort.Direction.ASC, "product");
			
			if (ProductSearchType.NAME.equals(productSearchFilter.getProductSearchType())) {
				return productRepository.findByName(productSearchFilter.getName(), pageable);
	
			} else if (ProductSearchType.PRICE_RANGE.equals(productSearchFilter.getProductSearchType())) {
				return productRepository.findByPriceRange(productSearchFilter.getInitialPrice(),
						productSearchFilter.getFinalPrice(), pageable);
			}
			
		} catch (Exception e) {
			throw e;
		}
		throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);
	}

	public void deleteAll() {
		try {
			productRepository.deleteAll();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void initDataBase() {
		List<String> files = Arrays.asList("/json/data_1.json", "/json/data_2.json", "/json/data_3.json",
				"/json/data_4.json");

		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<WrapperProduct> typeReference = new TypeReference<WrapperProduct>() {};

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
					e.printStackTrace();
				}

			}

		});
		
	}

}
