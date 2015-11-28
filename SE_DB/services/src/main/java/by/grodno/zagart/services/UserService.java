package by.grodno.zagart.services;

import by.grodno.zagart.dataaccess.model.User;

public interface UserService {

	void deleteUserById(Integer id);

	User getUserById(Integer id);

	void registerUser(String firstName, String lastName, String login, String email, String password, Integer countryId);
	
}
