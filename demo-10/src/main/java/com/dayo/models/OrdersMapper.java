package com.dayo.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrdersMapper implements RowMapper<OrderModel> {
	
	// TODO Auto-generated method stub
	
			//get the result ste
			
			//create a new order object
			
			//return it
	
	//ID	
	//ORDER_NUMBER	
	//PRODUCT_NAME	
	//PRICE	
	//QTY
	
//	from the mysql table columns
	
	

			

	@Override
	public OrderModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		OrderModel order =new OrderModel(rs.getLong("ID"), rs.getString("ORDER_NUMBER"), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QTY"));
		
		return order;
		


	}

}
