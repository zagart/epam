package by.grodno.zagart.services;

import by.grodno.zagart.dataaccess.model.User;

public interface UserService {

	void insertOrUpdate(User user);

	void registerUser(String firstName, String lastName, String login, String email, String password);
	
	User get(Long id);
}
