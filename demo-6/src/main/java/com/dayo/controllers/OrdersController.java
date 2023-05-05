package com.dayo.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dayo.models.LoginModel;
import com.dayo.models.OrderModel;
import com.dayo.services.OrdersBusinessService;
import com.dayo.services.OrdersBusinessServiceInterface;


@Controller
@RequestMapping("/orders")
public class OrdersController {


//	1ST IMPLEMENTATION OF AUTOWIRED
//	@Autowired
//	OrdersBusinessService service;
	
	
//	2ND IMPLEMENTATION OF AUTORIWRED
	OrdersBusinessServiceInterface service;
	
	
	

	@Autowired
	public OrdersController(OrdersBusinessServiceInterface service) {
	super();
	this.service = service;
}




	@GetMapping("/")
	public String showAllOrders(Model model) {
//		first  method
////		one class depends on another is called bad code styling
//		OrdersBusinessService service =new OrdersBusinessService();
//		List<OrderModel>orders=service.getOrders();
//	

		List<OrderModel>orders=service.getOrders();
		
model.addAttribute("title","Heres what I did in Summer");
model.addAttribute("orders",orders);
		return "orders.html";
		

		
	}
	
	
}
