package by.grodno.zagart.dataaccess.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import by.grodno.zagart.dataaccess.dao.ShoppingCartDao;
import by.grodno.zagart.dataaccess.model.ShoppingCart;

/**
 * Implementation of shopping cart model.
 * 
 * @author zagart
 *
 */
public class ShoppingCartDaoImpl implements ShoppingCartDao {

	@Autowired
	JdbcTemplate jdbc;

	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartDaoImpl.class);

	/**
	 * Method for getting shopping cart by id.
	 */
	@Override
	public ShoppingCart getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method for deleting shopping cart by id.
	 */
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	/**
	 * Method for adding new shopping cart.
	 */
	@Override
	public Integer insert(ShoppingCart cart) {
		// TODO Auto-generated method stub
		return null;
	}

}
