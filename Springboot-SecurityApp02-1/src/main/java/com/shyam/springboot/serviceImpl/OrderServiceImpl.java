package com.shyam.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shyam.springboot.entity.OrdersEntity;
import com.shyam.springboot.repository.OrderRepository;
import com.shyam.springboot.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrdersEntity addNewOrder(OrdersEntity orders) {
		// TODO Auto-generated method stub
		return orderRepository.save(orders);
	}

	@Override
	public List<OrdersEntity> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

}
