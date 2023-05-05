package com.dayo.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.dayo.models.OrderModel;

//@Primary
@Repository // identifies as a bean to be injected with Autowired
public class OrdersFakeDao2 implements OrdersDataAccessInterface{


	List<OrderModel> orders = new ArrayList<>();
	
	

	public OrdersFakeDao2() {
		orders.add(new OrderModel(0L, "000", "Big Mac", 5.00f, 2));
		orders.add(new OrderModel(1L, "001", "Large Fries", 3.00f, 3));
		orders.add(new OrderModel(2L, "002", "Chicken Nuggets", 4.00f, 4));
		orders.add(new OrderModel(3L, "003", "Cheeseburger", 2.50f, 2));
		orders.add(new OrderModel(4L, "004", "Double Cheeseburger", 3.50f, 1));
		orders.add(new OrderModel(5L, "005", "Quarter Pounder with Cheese", 4.50f, 2));
		orders.add(new OrderModel(6L, "006", "Filet-O-Fish", 4.00f, 3));
		orders.add(new OrderModel(7L, "007", "McChicken Sandwich", 3.50f, 4));
		orders.add(new OrderModel(8L, "008", "Bacon Clubhouse Burger", 5.50f, 2));
		orders.add(new OrderModel(9L, "009","Apple Pie" ,1.00f ,1 ));
		orders.add(new OrderModel(10L,"010","Milkshake" ,3.00f ,2 ));
		orders.add(new OrderModel(11L,"011","Hot Fudge Sundae" ,2.50f ,3 ));
		orders.add(new OrderModel(12L,"012","McFlurry" ,3.50f ,4 ));
		orders.add(new OrderModel(13L,"013","Soft Serve Cone" ,1.50f ,2 ));
		orders.add(new OrderModel(14L,"014","Chocolate Chip Cookie" ,0.50f ,1 ));
		orders.add(new OrderModel(15L,"015","Oreo McFlurry" ,3.50f ,2 ));
		orders.add(new OrderModel(16L,"016","Strawberry Sundae" ,2.50f ,3 ));
		orders.add(new OrderModel(17L,"017","Vanilla Milkshake" ,3.00f ,4 ));
		orders.add(new OrderModel(18L,"018","Chocolate Milkshake" ,3.00f ,2 ));
		orders.add(new OrderModel(19L,"019","Caramel Sundae" ,2.50f ,1 ));
	}

	@Override
	public OrderModel getById(long id) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getId()==id) {
				return orders.get(i); 
			}
		}
		// return nothing if exiting the loop
		return null;
	}

	@Override
	public List<OrderModel> getOrders() {
		return orders;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
		
//		method 2
		List<OrderModel> foundItems =  orders
					.stream()
					.filter(order->order.getProductName().toLowerCase()
							.contains(searchTerm.toLowerCase()))
					.collect(Collectors.toList());
			
		
		return foundItems;
//method 1
//		List<OrderModel> foundItems = new ArrayList<OrderModel>();
//		for (int i = 0; i < orders.size(); i++) {
//			if (orders.get(i).getProductName().toLowerCase().contains(searchTerm.toLowerCase())) {
//				foundItems.add(orders.get(i));
//			}
//			
	}
		

	

	@Override
	public long addOne(OrderModel newOrder) {
boolean success =orders.add(newOrder);
if(success) {
	return 1;
}else {
	return 0;
}
		
	
	}

	@Override
	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		// TODO Auto-generated method stub
		return null;
	}

}
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            