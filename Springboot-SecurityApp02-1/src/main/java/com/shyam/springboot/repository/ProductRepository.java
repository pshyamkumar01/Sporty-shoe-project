package com.shyam.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyam.springboot.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
