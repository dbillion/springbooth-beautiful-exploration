package com.dayo.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.dayo.models.OrderModel;


@Repository // identifies as a bean to be injected with Autowired
public class OrdersFakeDao2 implements OrdersDataAccessInterface{


	List<OrderModel> orders = new ArrayList<>();
	
	

	public OrdersFakeDao2() {
		orders.add(new OrderModel(0L, "ABC", "Museum Tickets in Spain", 30.00f, 2));
		orders.add(new OrderModel(1L, "ACC", "Restaurant in France", 80.00f, 3));
		orders.add(new OrderModel(2L, "ABB", "Hotel in Italy", 120.00f, 4));
		orders.add(new OrderModel(3L, "AAA", "Souvenirs in Germany", 50.00f, 2));
		orders.add(new OrderModel(4L, "DEF", "City Tour in Greece", 40.00f, 1));
		orders.add(new OrderModel(5L, "DEE", "Boat Tour in Portugal", 60.00f, 2));
		orders.add(new OrderModel(6L, "DFF", "Bike Rental in Belgium", 20.00f, 3));
		orders.add(new OrderModel(7L, "DED", "Amusement Park in Netherlands", 70.00f, 4));
		orders.add(new OrderModel(8L, "FEF", "Ski Pass in Switzerland", 100.00f, 2));
		orders.add(new OrderModel(9L, "EEF", "Opera Tickets in Austria", 90.00f, 1));
		orders.add(new OrderModel(10L,"GGI","Castle Tour in Denmark" ,50.00f ,2 ));
		orders.add(new OrderModel(11L,"GHH","Ferry Ride in Sweden" ,30.00f ,3 ));
		orders.add(new OrderModel(12L,"III","Hiking Tour in Norway" ,40.00f ,4 ));
		orders.add(new OrderModel(13L,"GHG","Sauna Experience in Finland" ,60.00f ,2 ));
		orders.add(new OrderModel(14L,"IHI","Glacier Tour in Iceland" ,80.00f ,1 ));
		orders.add(new OrderModel(15L,"JKL","Pub Crawl in Ireland" ,70.00f ,2 ));
		orders.add(new OrderModel(16L,"JKK","Theater Tickets in United Kingdom" ,90.00f ,3 ));
		orders.add(new OrderModel(17L,"JJJ","Historical Tour in Poland" ,50.00f ,4 ));
		orders.add(new OrderModel(18L,"LLL","Food Tour in Czech Republic" ,60.00f ,2 ));
		orders.add(new OrderModel(19L,"JLJ","Wine Tasting in Hungary" ,70.00f ,1 ));
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
