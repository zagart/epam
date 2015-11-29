package by.grodno.zagart.dataaccess.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.grodno.zagart.dataaccess.dao.OrderDao;
import by.grodno.zagart.dataaccess.dao.mapper.OrderMapper;
import by.grodno.zagart.dataaccess.model.Order;

/**
 * OrderDao interface implementation. Provides access to order table's content.
 * 
 * @author zagart
 *
 */
@Repository
public class OrderDaoImpl implements OrderDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Autowired
	JdbcTemplate jdbc;

	/**
	 * Method returns order table's row with pointed id column's value.
	 */
	@Override
	public Order getById(Integer id) {
		LOGGER.info("Trying to get order by id = {}...", id);
		return jdbc.queryForObject("SELECT * FROM \"order\" WHERE id = ?", new Object[] { id }, new OrderMapper());
	}

	/**
	 * Method lets delete order table's row by pointed id column's value.
	 */
	@Override
	public void deleteById(Integer id) {
		LOGGER.info("Trying to delete order by id = {}...", id);
		jdbc.update("DELETE FROM \"order\" WHERE id = " + id);
	}

	/**
	 * Method adds new row into order table.
	 */	
	@Override
	public Integer insert(Order order) {
		LOGGER.info("Trying to add order...");
		return jdbc.queryForObject(
				"INSERT INTO \"order\" (shopping_cart_id, date_of_order, date_of_deliver, order_status) VALUES (?,?,?,?) RETURNING id",
				new Object[] { order.getShoppingCartId(), order.getDateOfOrder(), order.getDateOfDeliver(),
						order.getOrderStatus() },
				Integer.class);
	}

}
