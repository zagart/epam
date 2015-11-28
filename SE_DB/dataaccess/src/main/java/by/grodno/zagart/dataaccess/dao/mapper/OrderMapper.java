package by.grodno.zagart.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import by.grodno.zagart.dataaccess.model.Order;

/**
 * Class that executes RowMapper interface for Order model.
 * 
 * @author zagart
 *
 */
public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		Integer shoppingCartId = rs.getInt("shopping_cart_id");
		Date dateOfOrder = rs.getDate("date_of_order");
		Date dateOfDeliver = rs.getDate("date_of_deliver");
		String orderStatus = rs.getString("order_status");
		order.setShoppingCartId(shoppingCartId);
		order.setDateOfOrder(dateOfOrder);
		order.setDateOfDeliver(dateOfDeliver);
		order.setOrderStatus(orderStatus);
		return order;
	}

}
