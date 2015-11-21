package by.grodno.zagart.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.grodno.zagart.dataaccess.dao.UserDao;
import by.grodno.zagart.dataaccess.dao.mapper.UserMapper;
import by.grodno.zagart.dataaccess.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	public static long ID_GEN;

	private static Map<Long, User> TABLE_USER = new HashMap<Long, User>();

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getById(Long id) {
		return jdbcTemplate.queryForObject("select * from user_account where id = ?", new Object[] { 1 }, new UserMapper());
	}

	@Override
	public void insert(User user) {
		jdbcTemplate.update(
				"INSERT INTO user_account (first_name, last_name, login, e_mail, password) VALUES (?,?,?,?,?)",
				user.getFirstName(), user.getLastName(), user.getLogin(), user.getEmail(), user.getPassword());
	}

	@Override
	public void update(User user) {
		User existingUser = TABLE_USER.get(user.getId());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
	}

}
