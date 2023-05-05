package com.dayo.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.dayo.models.OrderEntity;


@Component
public interface OrdersRepositoryInterface extends CrudRepository<OrderEntity, Long>{
	
//	use crud repository on mysql
//	crud save,findall,finbyid, delet by id
	
	List<OrderEntity> findByProductNameContainingIgnoreCase(String searchTerm);
	
	

}
