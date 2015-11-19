package com.epam.training.dataaccess.dao;

import com.epam.training.dataaccess.model.User;

public interface UserDao {

	User getById(Long id);

	void insert(User user);

	void update(User user);
}
