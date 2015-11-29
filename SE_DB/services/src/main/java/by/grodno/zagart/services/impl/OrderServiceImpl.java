package by.grodno.zagart.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.grodno.zagart.dataaccess.dao.impl.OrderDaoImpl;
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

	private static final Logger LOGGER = LoggerFactory.getLogger("OrderLogger");

	@Autowired
	private OrderDaoImpl orderDao;

	/**
	 * Getting order by id.
	 */
	@Override
	public Order getOrderById(Integer id) {
		LOGGER.info("Order with id = {} received.", id);
		return orderDao.getById(id);
	}

	/**
	 * Deleting order by id.
	 */
	@Override
	public void deleteOrderById(Integer id) {
		orderDao.deleteById(id);
		LOGGER.info("Deleted order with id = {}).", id);
	}

	/**
	 * Adding new order.
	 */
	@Override
	public Integer insertNewOrder(Order order) {
		int id = orderDao.insert(order);
		LOGGER.info("Added order with id = " + id);
		return id;
	}

}
