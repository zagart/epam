package by.grodno.zagart.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.grodno.zagart.dataaccess.model.Country;

/**
 * Implementation of RowMapper for model Country.
 * 
 * @author zagart
 *
 */
public class CountryMapper implements RowMapper<Country> {
	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		long id = rs.getLong("id");
		String name = rs.getString("name");
		int isoCode = rs.getInt("iso_code");
		Country country = new Country();
		country.setId(id);
		country.setIsoCode(isoCode);
		country.setName(name);
		return country;
	}
}
