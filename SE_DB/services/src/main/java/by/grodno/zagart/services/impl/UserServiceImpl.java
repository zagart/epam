package by.grodno.zagart.services.impl;

import java.util.Date;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.grodno.zagart.dataaccess.dao.UserDao;
import by.grodno.zagart.dataaccess.model.User;
import by.grodno.zagart.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@PostConstruct
	private void init() {

	}

	@Override
	public void insertOrUpdate(User user) {
		if (user.getId() == null) {
			userDao.insert(user);
		} else {
			userDao.update(user);
		}
	}

	@Override
	public void registerUser(String firstName, String lastName, String login, String email, String password) {

		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLogin(login);
		user.setPassword(password);
		userDao.insert(user);
		// send email
	}
	
	@Override
	public User get(Long id) {
		return userDao.getById(id);
	}
}
