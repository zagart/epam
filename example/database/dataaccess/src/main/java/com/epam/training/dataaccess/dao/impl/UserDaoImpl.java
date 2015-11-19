package com.epam.training.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.epam.training.dataaccess.dao.UserDao;
import com.epam.training.dataaccess.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	public static long ID_GEN;

	private static Map<Long, User> TABLE_USER = new HashMap<Long, User>();

	@Override
	public User getById(Long id) {
		return TABLE_USER.get(id);
	}

	@Override
	public void insert(User user) {
		user.setId(ID_GEN++);
		TABLE_USER.put(user.getId(), user);
	}

	@Override
	public void update(User user) {
		User existingUser = TABLE_USER.get(user.getId());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
	}

}
