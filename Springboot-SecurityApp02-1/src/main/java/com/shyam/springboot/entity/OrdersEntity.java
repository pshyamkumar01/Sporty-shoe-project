package com.shyam.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrdersEntity  extends DateAndTime
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String productName;
	private String category;
	private String size;
	private String price;
	
	public OrdersEntity() {
		super();
	}

	public OrdersEntity(String username) {
		super();
		this.username = username;
	}

	public OrdersEntity(String username, String productName, String category, String size, String price) {
		super();
		this.username = username;
		this.productName = productName;
		this.category = category;
		this.size = size;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

}
