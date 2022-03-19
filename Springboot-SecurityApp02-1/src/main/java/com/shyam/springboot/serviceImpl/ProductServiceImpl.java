package com.shyam.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shyam.springboot.entity.Products;
import com.shyam.springboot.repository.ProductRepository;
import com.shyam.springboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Products> getProductList() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Products getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	@Override
	public Products addNewProduct(Products products) {
		// TODO Auto-generated method stub
		return productRepository.save(products);
	}

	@Override
	public Products updateProduct(Products products) {
		// TODO Auto-generated method stub
		return productRepository.save(products);
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

}
