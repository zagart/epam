package by.grodno.zagart.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.grodno.zagart.dataaccess.dao.OrderDao;
import by.grodno.zagart.dataaccess.model.Order;
import by.grodno.zagart.services.OrderService;

/**
 * This class executes OrderService interface methods and provides access to
 * editing order table in database.
 * 
 * @author zagart
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	/**
	 * Getting order by id.
	 */
	@Override
	public Order getOrderById(long id) {
		return orderDao.getById(id);
	}

	/**
	 * Deleting order by id.
	 */
	@Override
	public void deleteOrderById(long id) {
		orderDao.deleteById(id);
	}

	/**
	 * Adding new order.
	 */
	@Override
	public void insertNewOrder(Order order) {
		orderDao.insert(order);
	}

}
