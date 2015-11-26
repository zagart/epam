package by.grodno.zagart.dataaccess.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
@Service
public class CountryDaoImpl implements CountryDao {

	@Autowired
	private JdbcTemplate jdbc;

	/**
	 * Method for getting Country object by pointed id value.
	 */
	@Override
	public Country getById(Long id) {
		return jdbc.queryForObject("SELECT * FROM country WHERE id = " + id, new CountryMapper());
	}

	/**
	 * Method for deleting Country row from table by it's id value.
	 */
	@Override
	public void deleteById(Long id) {
		jdbc.execute("DELETE FROM country WHERE id = " + id);
	}

	/**
	 * Method for adding new Country object into table.
	 */
	@Override
	public void insert(Country country) {
		jdbc.update("INSERT INTO country (id, name, iso_code) VALUES (?,?,?)", country.getId(), country.getName(),
				country.getIsoCode());
	}

}
