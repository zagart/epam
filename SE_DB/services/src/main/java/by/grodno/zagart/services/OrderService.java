package by.grodno.zagart.services;

import by.grodno.zagart.dataaccess.model.Order;

public interface OrderService {

	Order getOrderById(long id);
	
	void deleteOrderById(long id);
	
	void insertNewOrder(Order order);
	
}
