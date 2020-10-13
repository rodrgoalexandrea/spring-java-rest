package com.teste.javaspring.util;

import java.math.BigDecimal;

import com.teste.javaspring.enums.ProductSearchType;

public class ProductSearchFilter {

	private String name;

	private BigDecimal initialPrice;

	private BigDecimal finalPrice;

	private ProductSearchType productSearchType;

	private int pageSize;

	private int pageNumber;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public ProductSearchType getProductSearchType() {
		return productSearchType;
	}

	public void setProductSearchType(ProductSearchType productSearchType) {
		this.productSearchType = productSearchType;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	
}
