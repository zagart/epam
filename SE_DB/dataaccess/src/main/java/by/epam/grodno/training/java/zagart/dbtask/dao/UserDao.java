package by.epam.grodno.training.java.zagart.dbtask.dao;

import by.epam.grodno.training.java.zagart.dbtask.model.User;

public interface UserDao {

	User getById(Long id);

	void insert(User user);

	void update(User user);
}
