package com.dayo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service; 
import com.dayo.data.OrdersDataAccessInterface;
import com.dayo.models.OrderModel;


public class OrdersBusinessService implements OrdersBusinessServiceInterface{
	
	@Autowired
	OrdersDataAccessInterface<OrderModel> ordersDAO; // dependencies injection from the OrdersDataAccessInterface class
	

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("order Business service is workibg");
	}

	@Override
	public List<OrderModel> getOrders() {
		
		return ordersDAO.getOrders();
	}

	@Override
	public OrderModel getById(long id) {
		
		return ordersDAO.getById(id);
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		return ordersDAO.searchOrders(searchTerm);
	}

	@Override
	public long addOne(OrderModel newOrder) {

		
		return ordersDAO.addOne(newOrder);
	}

	@Override
	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		
		
		return ordersDAO.deleteOne(id);
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		// TODO Auto-generated method stub
		
		return ordersDAO.updateOne(idToUpdate, updateOrder);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}



}
