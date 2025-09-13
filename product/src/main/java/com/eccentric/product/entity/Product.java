package com.eccentric.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	private Long id;
	private String name;
	private String brand;
	private Double price;
	private String description;
	private String imgPath;
	private Integer stock = 10;

	public Product() {}

	public Product(Long id, String name, String brand, Double price, String description, String imgPath, Integer stock) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.imgPath = imgPath;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBand() {
		return brand;
	}
	public void setBand(String band) {
		this.brand = band;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
