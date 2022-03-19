package com.shyam.springboot.service;

import java.util.List;

import com.shyam.springboot.entity.Products;

public interface ProductService {

	List<Products> getProductList();
	
	Products getProductById(Long id);
	
	Products addNewProduct(Products products);
	
	Products updateProduct(Products products);
	
	void deleteProduct(Long id);
}
