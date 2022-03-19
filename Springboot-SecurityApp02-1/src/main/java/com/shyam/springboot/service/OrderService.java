package com.shyam.springboot.service;

import java.util.List;

import com.shyam.springboot.entity.OrdersEntity;

public interface OrderService {

	OrdersEntity addNewOrder(OrdersEntity orders);

	List<OrdersEntity> getAllOrders();
}
