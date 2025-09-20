package com.eccentric.product.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductRequest {

	private String name;
	private String description;
	private Double price;
	private String brand;
	private Integer stock;
	private MultipartFile file;

	public ProductRequest() {}

	public ProductRequest(String name, String description, Double price, String brand, Integer stock, MultipartFile file) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.brand = brand;
		this.stock = stock;
		this.file = file;
	}

	public ProductRequest(Builder builder) {
		builder.name = name;
		builder.description = description;
		builder.price = price;
		builder.brand = brand;
		builder.stock = stock;
		builder.file = file;
	}

	public static class Builder {
		private String name;
		private String description;
		private Double price;
		private String brand;
		private Integer stock;
		private MultipartFile file;

		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		public Builder price(Double price) {
			this.price = price;
			return this;
		}
		public Builder brand(String brand) {
			this.brand = brand;
			return this;
		}
		public Builder stock(Integer stock) {
			this.stock = stock;
			return this;
		}
		public Builder file(MultipartFile file) {
			this.file = file;
			return this;
		}

		public ProductRequest build() {
			return new ProductRequest(this);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
