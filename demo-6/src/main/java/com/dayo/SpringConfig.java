package com.dayo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dayo.services.OrdersBusinessService;
import com.dayo.services.OrdersBusinessService2;
import com.dayo.services.OrdersBusinessServiceInterface;

@Configuration
public class SpringConfig {
	@Bean(name="ordersBusinessService")
	public OrdersBusinessServiceInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}

}
