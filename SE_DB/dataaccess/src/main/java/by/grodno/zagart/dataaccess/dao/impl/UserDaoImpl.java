package by.grodno.zagart.dataaccess.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.grodno.zagart.dataaccess.dao.UserDao;
import by.grodno.zagart.dataaccess.dao.mapper.UserMapper;
import by.grodno.zagart.dataaccess.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Method for getting User object with pointed id value from table.
	 */
	@Override
	public User getById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM user_account WHERE id = " + id, new UserMapper());
	}

	/**
	 * Method for adding new User object into table.
	 */
	@Override
	public void insert(User user) {
		jdbcTemplate.update(
				"INSERT INTO user_account (first_name, last_name, login, e_mail, password, balance, country_id, date_of_creation) VALUES (?,?,?,?,?,?,?,?)",
				user.getFirstName(), user.getLastName(), user.getLogin(), user.getEmail(), user.getPassword(),
				user.getBalance(), user.getCountryId(), user.getCreationDate());
	}

	/**
	 * Method for deleting user from table by this user's id value.
	 */
	@Override
	public void deleteById(Long id) {
		jdbcTemplate.update("DELETE FROM user_account WHERE id = " + id);
	}

}
