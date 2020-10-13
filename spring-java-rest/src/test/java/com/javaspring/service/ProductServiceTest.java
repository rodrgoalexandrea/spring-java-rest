package com.javaspring.service;

import static org.junit.Assert.assertSame;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teste.javaspring.enums.ProductSearchType;
import com.teste.javaspring.model.Product;
import com.teste.javaspring.repository.ProductRepository;
import com.teste.javaspring.service.ProductService;
import com.teste.javaspring.util.ProductSearchFilter;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	@Mock
	ProductSearchFilter productSearchFilter;
	
	@org.junit.Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindByFilter_Name() {
		
		Page<Product> pageStub = (Page<Product>)Mockito.mock(Page.class);
		Mockito.when(productRepository.findByName(Mockito.anyString(), Mockito.any(Pageable.class)))
				.thenReturn(pageStub);

		productSearchFilter = new ProductSearchFilter();
		productSearchFilter.setProductSearchType(ProductSearchType.NAME);
		productSearchFilter.setName("Teste");
		productSearchFilter.setPageSize(10);
		productSearchFilter.setPageNumber(1);
		Page<Product> results = productService.findByFilter(productSearchFilter);
		
//		Pageable pageable = PageRequest.of(productSearchFilter.getPageNumber(), productSearchFilter.getPageSize());
		Pageable pageableStub = Mockito.mock(Pageable.class);

		Mockito.verify(productRepository.findByName(productSearchFilter.getName(), pageableStub),
				Mockito.times(1));
		
		assertSame(pageStub, results);
		
		Assert.assertNotNull(results);
	}
	
	
	@Test
	public void testFindByFilter_PriceRange() {
		Page<Product> pageStub = (Page<Product>)Mockito.mock(Page.class);
		
		Mockito.when(productRepository.findByPriceRange(new BigDecimal(Mockito.anyDouble()), 
				new BigDecimal(Mockito.anyDouble()), Mockito.any(Pageable.class)))
				.thenReturn(pageStub);
		
		productSearchFilter = new ProductSearchFilter();
		productSearchFilter.setProductSearchType(ProductSearchType.PRICE_RANGE);
		productSearchFilter.setName("Teste");
		productSearchFilter.setPageSize(10);
		productSearchFilter.setPageNumber(1);
		productSearchFilter.setInitialPrice(new BigDecimal("0.67"));
		productSearchFilter.setFinalPrice(new BigDecimal("2.00"));
		
		Page<Product> results = productService.findByFilter(productSearchFilter);

        Pageable pageableStub = Mockito.mock(Pageable.class);
		
		Mockito.verify(productRepository.findByPriceRange(productSearchFilter.getInitialPrice(),
				productSearchFilter.getFinalPrice(), pageableStub),
				Mockito.times(1)).getContent();
		
//		assertSame(pageStub, results);
		
//		Assert.assertNotNull(results);
		
		
	}

}
