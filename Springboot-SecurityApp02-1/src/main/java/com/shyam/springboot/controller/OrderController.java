package com.shyam.springboot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shyam.springboot.entity.OrdersEntity;
import com.shyam.springboot.service.OrderService;

@Controller
public class OrderController {

	private OrderService orderService;
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@Autowired
	UserController  userController;
	
	
	@PostMapping("/orderProduct{id}")
	public String order(@ModelAttribute("newuser") OrdersEntity order)
	{
		order.setUsername(userController.getUserName());
		order.setCreatedDate(new Date());
		orderService.addNewOrder(order);
		return "redirect:/productlist";
	}
	
	@GetMapping("/orderslist")
	public String listOfOrders(Model model)
	{
		model.addAttribute("orderslist", orderService.getAllOrders());
		
		return "ListOfOrders";
	}
}
