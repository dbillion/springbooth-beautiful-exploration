package com.dayo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dayo.models.OrderModel;


public class OrdersBusinessService implements OrdersBusinessServiceInterface{

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("order Business service is workibg");
	}

	@Override
	public List<OrderModel> getOrders() {
	
		List<OrderModel> orders = new ArrayList<>();
		
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
		return orders;
	}



}
