package com.dayo.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dayo.models.OrderEntity;
import com.dayo.models.OrderModel;




@Repository
public class OrdersDataServiceForRepository implements OrdersDataAccessInterface<OrderModel> {

//	needs a data sources
	
	@Autowired
	OrdersRepositoryInterface ordersRepository;
	
	private JdbcTemplate jdbcTemplate;
	

	
	public OrdersDataServiceForRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public OrderModel getById(long id) {
		// TODO Auto-generated method stub
		
		OrderEntity entity = ordersRepository.findById(id).orElse(null);
		
//		OrderModel model = new OrderModel(
//				entity.getId(),
//				entity.getOrderNo(), 
//				entity.getProductName(), 
//				entity.getPrice(),
//				entity.getQuantity());
		
		
		OrderModel model = modelMapper.map(entity, OrderModel.class);				
		return model;
	}

	@Override
	public List<OrderModel> getOrders() {
		// TODO Auto-generated method stub
		
		Iterable<OrderEntity> ordersEntity = ordersRepository.findAll();
		
		List<OrderModel> models = new ArrayList<OrderModel>();
		
		for (OrderEntity item : ordersEntity) {
			models.add(modelMapper.map(item, OrderModel.class));
		}
		return models;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long addOne(OrderModel newOrder) {
		// TODO Auto-generated method stub
		return 0;
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
