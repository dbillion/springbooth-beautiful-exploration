package com.dayo.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.dayo.models.OrderModel;
import com.dayo.models.SearchModel;
import com.dayo.services.OrdersBusinessServiceInterface;


@Controller
@RequestMapping("/orders")
public class OrdersController {

//	1ST IMPLEMENTATION OF AUTOWIRED
//	@Autowired
//	OrdersBusinessService service;
	
	
//	2ND IMPLEMENTATION OF AUTORIWRED
	@Autowired
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
	
	@GetMapping("/showNewOrder")
	public String showNewForm(Model model) {
			
		model.addAttribute("order",new OrderModel());
		return "addNewOrderForm.html";

	}
	
	@PostMapping("/addNew")
	public  String addnew(@Valid OrderModel newOrder, BindingResult bindResult, Model model) {
		// Processing the data
		newOrder.setId(null);
		
//		 add to the database
		
		service.addOne(newOrder);
		
		List<OrderModel> orders =service.getOrders();
//		show all orders page
		
		model.addAttribute("orders", orders);
		
		
		return "orders.html";

	}
	
	@GetMapping("/showSearchForm")
	public String showSearchForm(Model model) {
			
		model.addAttribute("searchModel",new SearchModel());
		return "searchForm.html";

	}
	
	@PostMapping("/search")
	public String search(@Valid SearchModel searchModel, BindingResult bindResult, Model model) {
		
		String searchTerm = searchModel.getSearchTerm();
		
		
		List<OrderModel> orders =service.searchOrders(searchTerm);
//		show all orders page
		
		model.addAttribute("orders", orders);
		
		
		return "orders";
		// TODO Auto-generated method stub

	}
	
	
	
	@GetMapping("/admin")
	public String showAdminPage(Model model) {

		List<OrderModel>orders=service.getOrders();
		
model.addAttribute("title","Heres what I did in Summer");
model.addAttribute("orders",orders);
		return "ordersAdmin.html";	
	}
	
	
	
	@PostMapping("/editForm/")
	public String displayEditForm(OrderModel orderModel, Model model) {

		model.addAttribute("title","Edit order");
		model.addAttribute("orderModel",orderModel);
		return "editForm.html";	
	}
	
	
	
	

	@PostMapping("/doUpdate")
	public String updateOrder(@Valid OrderModel order, BindingResult bindResult, Model model) {
	// 	add the new order
		service.updateOne(order.getId(), order);
//		get updated list of all the orders	
		List<OrderModel>orders=service.getOrders();
//		display all orders
		model.addAttribute("orders",orders);
		return "ordersAdmin.html";	
	}
	
	
	
	
	
	
	
	
}
