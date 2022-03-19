package com.shyam.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shyam.springboot.entity.OrdersEntity;

public interface OrderRepository extends JpaRepository<OrdersEntity, Long>{

}
