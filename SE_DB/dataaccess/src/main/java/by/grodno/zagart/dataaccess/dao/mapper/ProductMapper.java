package by.grodno.zagart.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.grodno.zagart.dataaccess.model.Product;

/**
 * Mapper for product model.
 * 
 * @author zagart
 *
 */
public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setCost(rs.getBigDecimal("cost"));
		product.setRating(rs.getInt("rating"));
		return product;
	}

}
