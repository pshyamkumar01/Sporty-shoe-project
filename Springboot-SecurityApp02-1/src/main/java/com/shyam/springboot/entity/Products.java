package com.shyam.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String category;
	private String productName;
	private long size;
	private long price;
	
	public Products() {
		super();
	}

	public Products(String category, String productName, long size, long price) {
		super();
		this.category = category;
		this.productName = productName;
		this.size = size;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	
}
