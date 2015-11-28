package by.grodno.zagart.services;

import by.grodno.zagart.dataaccess.model.Order;

public interface OrderService {

	Order getOrderById(Integer id);
	
	void deleteOrderById(Integer id);
		
	void insertNewOrder(Order order);
	
}
