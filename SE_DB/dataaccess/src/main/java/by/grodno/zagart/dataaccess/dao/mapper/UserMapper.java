package by.grodno.zagart.dataaccess.dao.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import by.grodno.zagart.dataaccess.model.User;

/**
 * Implementation of RowMapper for model User. 
 * 
 * @author zagart
 *
 */
public final class UserMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String fName = rs.getString("first_name");
		String lName = rs.getString("last_name");
		String login = rs.getString("login");
		String email = rs.getString("e_mail");
		String password = rs.getString("password");
		BigDecimal balance = rs.getBigDecimal("balance");
		int countryId = rs.getInt("country_id");
		Date dateOfCreation = rs.getDate("date_of_creation");
		User user = new User();
		user.setId(id);
		user.setFirstName(fName);
		user.setLastName(lName);
		user.setLogin(login);
		user.setEmail(email);
		user.setPassword(password);
		user.setBalance(balance);
		user.setCountryId(countryId);
		user.setDateOfCreation(dateOfCreation);
		return user;
	}
}