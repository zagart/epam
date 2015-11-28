package by.grodno.zagart.dataaccess.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.grodno.zagart.dataaccess.dao.ProductListDao;
import by.grodno.zagart.dataaccess.dao.mapper.ProductListMapper;
import by.grodno.zagart.dataaccess.model.ProductList;

@Repository
public class ProductListDaoImpl implements ProductListDao {

	@Autowired
	JdbcTemplate jdbc;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductListDaoImpl.class);

	@Override
	public ProductList getById(Integer id) {
		LOGGER.info("Trying to get product list by id = {}...", id);
		return jdbc.queryForObject("SELECT * FROM product_list WHERE id = " + id, new ProductListMapper());
	}

	@Override
	public void deleteById(Integer id) {
		LOGGER.info("Trying to delete product list by id = {}...", id);
		jdbc.update("DELETE FROM product_list WHERE id = " + id);
	}

	@Override
	public Integer insert(ProductList list) {
		LOGGER.info("Trying to add product list...");
		int id = jdbc.queryForObject(
				"INSERT INTO product_list (product_id, product_quantity) VALUES (?,?) RETURNING id",
				new Object[] { list.getProductId(), list.getProductQuantity() }, Integer.class);
		return id;
	}

}
