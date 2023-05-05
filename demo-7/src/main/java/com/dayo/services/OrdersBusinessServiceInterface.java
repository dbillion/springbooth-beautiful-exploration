package com.dayo.services;

import java.util.List;

import com.dayo.models.OrderModel;

public interface OrdersBusinessServiceInterface {

	public void test();
	public void init();
	public void destroy();
	
	public List<OrderModel> getOrders();
//	future methods
	
	public List<OrderModel> searchOrders(String searchTerm) ;
	public long addOne(OrderModel newOrder);
	public boolean deleteOne(long id) ;
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) ;
	public OrderModel getById(long id);
	
	 
}
