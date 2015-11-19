package by.epam.grodno.training.java.zagart.dbtask.services.impl;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.training.java.zagart.dbtask.dao.UserDao;
import by.epam.grodno.training.java.zagart.dbtask.model.User;
import by.epam.grodno.training.java.zagart.dbtask.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@PostConstruct
	private void init() {
		System.out.print(true);
	}

	@Override
	public void insertOrUpdate(User user) {
//		if (user.getId() == null) {
//			userDao.insert(user);
//		} else {
//			userDao.update(user);
//		}
	}

	@Override
	public void registerUser(String firstName, String lastName, String email) {

		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
//		user.setLastName(lastName);
//		user.setCreationDate(new Date());
		userDao.insert(user);
		// send email
	}

	@Override
	public void blockOrUnlockUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
