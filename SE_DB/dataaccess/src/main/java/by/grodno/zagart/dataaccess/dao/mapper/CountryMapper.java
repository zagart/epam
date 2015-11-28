package by.grodno.zagart.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
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
		Country country = new Country();
		Integer id = rs.getInt("id");
		String name = rs.getString("name");
		Integer isoCode = rs.getInt("iso_code");
		country.setId(id);
		country.setName(name);
		country.setIsoCode(isoCode);
		return country;
	}
}
