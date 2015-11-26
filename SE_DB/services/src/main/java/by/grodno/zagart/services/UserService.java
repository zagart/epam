package by.grodno.zagart.services;

import by.grodno.zagart.dataaccess.model.User;

public interface UserService {

	void deleteUserById(Long id);

	User getUserById(Long id);

	void registerUser(String firstName, String lastName, String login, String email, String password, Long countryId);
	
}
