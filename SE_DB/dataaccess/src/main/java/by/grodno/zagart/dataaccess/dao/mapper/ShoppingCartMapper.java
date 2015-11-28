package by.grodno.zagart.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.grodno.zagart.dataaccess.model.ShoppingCart;

/**
 * Mapper for shopping cart model.
 * 
 * @author zagart
 *
 */
public class ShoppingCartMapper implements RowMapper<ShoppingCart> {

	@Override
	public ShoppingCart mapRow(ResultSet rs, int rowNum) throws SQLException {
		ShoppingCart cart = new ShoppingCart();
		cart.setId(rs.getInt("id"));
		cart.setId(rs.getInt("user_id"));
		cart.setId(rs.getInt("product_list_id"));
		cart.setTotalTost(rs.getBigDecimal("total_cost"));
		return cart;
	}

}
