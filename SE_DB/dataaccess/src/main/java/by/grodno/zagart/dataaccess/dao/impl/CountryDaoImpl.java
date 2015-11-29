package by.grodno.zagart.dataaccess.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.grodno.zagart.dataaccess.dao.CountryDao;
import by.grodno.zagart.dataaccess.dao.mapper.CountryMapper;
import by.grodno.zagart.dataaccess.model.Country;

/**
 * Implementation of CountryDao interface that executes Country model access
 * methods.
 * 
 * @author zagart
 *
 */
@Repository
public class CountryDaoImpl implements CountryDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbc;

	/**
	 * Method for getting Country object by pointed id value.
	 */
	@Override
	public Country getById(Integer id) {
		LOGGER.info("Trying to get country by id = {}...", id);
		return jdbc.queryForObject("SELECT * FROM country WHERE id = " + id, new CountryMapper());
	}

	/**
	 * Method for deleting Country row from table by it's id value.
	 */
	@Override
	public void deleteById(Integer id) {
		LOGGER.info("Trying to delete country by id = {}...", id);
		jdbc.update("DELETE FROM country WHERE id = " + id);
	}

	/**
	 * Method for adding new Country object into table.
	 */
	@Override
	public Integer insert(Country country) {
		LOGGER.info("Trying to add country...");
		int id = jdbc.queryForObject("INSERT INTO country (name, iso_code) VALUES (?,?) RETURNING id",
				new Object[] { country.getName(), country.getIsoCode() }, Integer.class);
		return id;
	}

}
