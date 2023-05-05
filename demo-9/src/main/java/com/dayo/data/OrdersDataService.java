package com.dayo.data;
import com.dayo.models.OrdersMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.dayo.models.OrderModel;

//@Primary
@Repository
public class OrdersDataService implements OrdersDataAccessInterface <OrderModel> {

	//see application.properties file to the detail on the mysql connection
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public OrderModel getById(long id) {
		List <OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS WHERE ID=?", new OrdersMapper(), id);
		
		if(results.size()>0) {
			return results.get(0);
		}
		
		return null;
	}

	@Override
	public List<OrderModel> getOrders() {
		// TODO Auto-generated method stub
		List<OrderModel> results =	jdbcTemplate.query("SELECT * FROM ORDERS", new OrdersMapper());
		// TODO Auto-generated method stub
		return results;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
		List<OrderModel> results =	jdbcTemplate.query("SELECT * FROM ORDERS WHERE PRODUCT_NAME LIKE ?", new OrdersMapper(), "%"+ searchTerm+"%");
		
		return results;
	}

	@Override
	public long addOne(OrderModel newOrder) {
		// TODO Auto-generated method stub
		
//		long result = jdbcTemplate.update("INSERT INTO ORDERS (ORDER_NUMBER, PRODUCT_NAME, PRICE, QTY) VALUES (?,?,?,?)", 
//
//				newOrder.getOrderNo(),
//				newOrder.getProductName(),
//				newOrder.getPrice(),
//				newOrder.getQuantity());
//				
//		return result;
		
		
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
		
		simpleInsert.withTableName("ORDERS").usingGeneratedKeyColumns("ID");
//		mao ofd column names
		
		Map<String,Object> parameters = new HashMap<String, Object>();
		
		parameters.put("ORDER_NUMBER", newOrder.getOrderNo());
		parameters.put("PRODUCT_NAME", newOrder.getProductName());
		parameters.put("PRICE", newOrder.getPrice());
		parameters.put("QTY", newOrder.getQuantity());
		
		
		Number result= simpleInsert.executeAndReturnKey(parameters);
		return result.longValue();
	}

	@Override
	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		int result= jdbcTemplate.update("DELETE FROM ORDERS WHERE ID = ?",id);
		if(result>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		// TODO Auto-generated method stub
		int result= jdbcTemplate.update("UPDATE ORDERS SET ORDER_NUMBER=?, PRODUCT_NAME=?, PRICE=?,QTY = ? WHERE ID = ? ",
				
				updateOrder.getOrderNo(),
				updateOrder.getProductName(),
				updateOrder.getPrice(),
				updateOrder.getQuantity(),
				idToUpdate);
				
		
		if (result>0) {
			return updateOrder;
		}
		return null;
	}

}
