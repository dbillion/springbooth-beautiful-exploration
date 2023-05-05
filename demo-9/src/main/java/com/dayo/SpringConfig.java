package com.dayo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.dayo.data.OrdersDataAccessInterface;
import com.dayo.data.OrdersDataServiceForRepository;
import com.dayo.services.OrdersBusinessService;
//import com.dayo.services.OrdersBusinessService2;
import com.dayo.services.OrdersBusinessServiceInterface;

import groovy.lang.Singleton;

@Configuration
public class SpringConfig {
	@Bean(name="ordersBusinessService",initMethod="init",destroyMethod="destroy")
	@RequestScope
	public OrdersBusinessServiceInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}

	@Autowired
	DataSource dataSource;
	
	@Bean(name="ordersDAO")
	@RequestScope
	public OrdersDataAccessInterface getDataService() {
		return new OrdersDataServiceForRepository(dataSource);
//		return new OrdersDataService();
	}
}
