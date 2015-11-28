package by.grodno.zagart.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.grodno.zagart.dataaccess.model.ProductList;

/**
 * Mapper for OrderList model.
 * 
 * @author zagart
 *
 */
public class ProductListMapper implements RowMapper<ProductList> {

	@Override
	public ProductList mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductList list = new ProductList();
		list.setId(rs.getInt("id"));
		list.setProductId(rs.getInt("product_id"));
		list.setProductQuantity(rs.getInt("product_quantity"));
		return list;
	}

}
