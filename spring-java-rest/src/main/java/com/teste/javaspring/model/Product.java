package com.teste.javaspring.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.teste.javaspring.util.PriceDeserializer;

@Entity
public class Product {

	@Id
	private String product;

	private Integer quantity;

	private String type;

	private String industry;

	private String origin;

	@JsonDeserialize(using = PriceDeserializer.class)
	private BigDecimal price;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null)
			return false;

		if (!(o instanceof Product))
			return false;

		Product product = (Product) o;

		if (Objects.equals(this.product, product.getProduct()) && Objects.equals(this.quantity, product.getQuantity())
				&& Objects.equals(this.type, product.type) && Objects.equals(this.origin, product.origin)
				&& Objects.equals(this.price, product.price)) {

			return true;

		}

		return super.equals(o);
	}
}
