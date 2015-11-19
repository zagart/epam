package com.epam.training.services;

import com.epam.training.dataaccess.model.User;

public interface UserService {

	void insertOrUpdate(User user);

	void registerUser(String firstName, String lastName, String email);
}
