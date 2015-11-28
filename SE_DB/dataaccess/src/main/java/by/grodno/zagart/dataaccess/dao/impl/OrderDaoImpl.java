package by.grodno.zagart.dataaccess.dao.impl;

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

	@Autowired
	JdbcTemplate jdbc;

	/**
	 * Method returns order table's row with pointed id column's value.
	 */
	@Override
	public Order getById(Integer id) {
		return jdbc.queryForObject("SELECT * FROM \"order\" WHERE id = ?", new Object[] { id }, new OrderMapper());
	}

	/**
	 * Method lets delete order table's row by pointed id column's value.
	 */
	@Override
	public void deleteById(Integer id) {
		jdbc.update("DELETE FROM \"order\" WHERE id = " + id);
	}

	/**
	 * Method adds new row into order table.
	 */
	@Override
	public void insert(Order order) {
		jdbc.update(
				"INSERT INTO \"order\" (id, shopping_cart_id, date_of_order, date_of_deliver, order_status) VALUES (?,?,?,?,?)",
				order.getId(), order.getShoppingCartId(), order.getDateOfOrder(), order.getDateOfDeliver(),
				order.getOrderStatus());
	}

}
