package by.grodno.zagart.dataaccess.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.grodno.zagart.dataaccess.dao.ProductDao;
import by.grodno.zagart.dataaccess.dao.mapper.ProductMapper;
import by.grodno.zagart.dataaccess.model.Product;

/**
 * Implementation of product model for DAO layer.
 * 
 * @author zagart
 *
 */
@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	JdbcTemplate jdbc;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductDaoImpl.class);

	/**
	 * Getting product by pointed id from database.
	 */
	@Override
	public Product getById(Integer id) {
		LOGGER.info("Trying to get product by id = {}...", id);
		return jdbc.queryForObject("SELECT * FROM \"product\" WHERE id = " + id, new ProductMapper());
	}

	/**
	 * Deleting product by pointed id from database.
	 */
	@Override
	public void deleteById(Integer id) {
		LOGGER.info("Trying to delete product by id = {}...", id);
		jdbc.update("DELETE FROM \"product\" WHERE id = " + id);
	}

	/**
	 * Adding new product to database.
	 */
	@Override
	public Integer insert(Product product) {
		LOGGER.info("Trying to add product...");
		Integer id = jdbc.queryForObject(
				"INSERT INTO \"product\" (name, description, cost, rating) VALUES (?,?,?,?) RETURNING id",
				new Object[] { product.getName(), product.getDescription(), product.getCost(), product.getRating() },
				Integer.class);
		return id;
	}

}
