package by.grodno.zagart.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import by.grodno.zagart.dataaccess.model.User;

public final class UserMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String fName = rs.getString("first_name");
		String lName = rs.getString("last_name");
		String email = rs.getString("email");
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setFirstName(fName);
		user.setLastName(lName);
		return user;
	}
}