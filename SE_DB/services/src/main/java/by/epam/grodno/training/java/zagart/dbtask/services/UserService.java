package by.epam.grodno.training.java.zagart.dbtask.services;

import by.epam.grodno.training.java.zagart.dbtask.model.User;

public interface UserService {

	void insertOrUpdate(User user);

	void registerUser(String firstName, String lastName, String email);
	
	void blockOrUnlockUser(User user);
}
