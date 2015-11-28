package by.grodno.zagart.services.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.grodno.zagart.dataaccess.dao.impl.UserDaoImpl;
import by.grodno.zagart.dataaccess.model.User;
import by.grodno.zagart.services.UserService;

/**
 * Class which implements UserService interface.
 * 
 * @author zagart
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl userDao;

	/**
	 * Method for registering new user.
	 */
	@Override
	public void registerUser(String firstName, String lastName, String login, String email, String password,
			Integer countryId) {
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLogin(login);
		user.setPassword(password);
		user.setBalance(new BigDecimal(0));
		user.setDateOfCreation(new Date());
		user.setCountryId(countryId);
		userDao.insert(user);
		// send email
	}

	/**
	 * Method for getting user by id.
	 */
	@Override
	public User getUserById(Integer id) {
		return userDao.getById(id);
	}

	/**
	 * Method for deleting user by id.
	 */
	@Override
	public void deleteUserById(Integer id) {
		userDao.deleteById(id);
	}

}
