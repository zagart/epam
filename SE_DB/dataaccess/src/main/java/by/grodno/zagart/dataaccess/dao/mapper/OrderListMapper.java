package by.grodno.zagart.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.grodno.zagart.dataaccess.model.OrderList;

/**
 * Mapper for OrderList model.
 * 
 * @author zagart
 *
 */
public class OrderListMapper implements RowMapper<OrderList> {

	@Override
	public OrderList mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderList list = new OrderList();
		list.setId(rs.getInt("id"));
		list.setProductId(rs.getInt("product_id"));
		list.setProductQuantity(rs.getInt("product_quantity"));
		return list;
	}

}
