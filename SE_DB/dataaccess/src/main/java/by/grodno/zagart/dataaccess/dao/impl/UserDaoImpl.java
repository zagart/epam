package by.grodno.zagart.dataaccess.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.grodno.zagart.dataaccess.dao.UserDao;
import by.grodno.zagart.dataaccess.dao.mapper.UserMapper;
import by.grodno.zagart.dataaccess.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Method for getting User object with pointed id value from table.
	 */
	@Override
	public User getById(Integer id) {
		LOGGER.info("Trying to get user by id = {}...", id);
		return jdbcTemplate.queryForObject("SELECT * FROM user_account WHERE id = " + id, new UserMapper());
	}

	/**
	 * Method for adding new User object into table.
	 */
	@Override
	public Integer insert(User user) {
		LOGGER.info("Trying to add user...");
		int id = jdbcTemplate.queryForObject(
				"INSERT INTO user_account (first_name, last_name, login, e_mail, password, balance, country_id, date_of_creation) VALUES (?,?,?,?,?,?,?,?) RETURNING id",
				new Object[] { user.getFirstName(), user.getLastName(), user.getLogin(), user.getEmail(),
						user.getPassword(), user.getBalance(), user.getCountryId(), user.getDateOfCreation() },
				Integer.class);
		return id;
	}

	/**
	 * Method for deleting user from table by this user's id value.
	 */
	@Override
	public void deleteById(Integer id) {
		LOGGER.info("Trying to delete user by id = {}...", id);
		jdbcTemplate.update("DELETE FROM user_account WHERE id = " + id);
	}

}
