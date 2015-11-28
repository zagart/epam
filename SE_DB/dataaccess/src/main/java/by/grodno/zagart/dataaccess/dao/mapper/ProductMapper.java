package by.grodno.zagart.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.grodno.zagart.dataaccess.model.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setCost(rs.getBigDecimal("cost"));
		product.setShopId(rs.getInt("shop_id"));
		product.setDeliverCost(rs.getBigDecimal("deliver_cost"));
		product.setProductsQuantityLeft(rs.getInt("product_quantity_left"));
		product.setRating(rs.getShort("rating"));
		return product;
	}

}
