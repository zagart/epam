package by.grodno.zagart.dataaccess.dao;

import by.grodno.zagart.dataaccess.model.User;

public interface UserDao {

	User getById(Long id);

	void insert(User user);

	void update(User user);
}
