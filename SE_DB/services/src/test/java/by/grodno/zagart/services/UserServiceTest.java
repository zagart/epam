package by.grodno.zagart.services;

import java.util.Random;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import by.grodno.zagart.dataaccess.model.User;
import by.grodno.zagart.services.impl.CountryServiceImpl;
import by.grodno.zagart.services.impl.UserServiceImpl;

/**
 * Class for testing UserService methods which use JUnit tests.
 * 
 * @author zagart
 *
 */
public class UserServiceTest extends AbstractSpringClass {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private CountryServiceImpl countryService;

	private Integer id;

	@Test
	public void registerUserTest() {
		Random rnd = new Random();
		String firstName = RandomStringUtils.random(rnd.nextInt(50));
		String lastName = RandomStringUtils.random(rnd.nextInt(50));
		String login = RandomStringUtils.random(rnd.nextInt(120));
		String email = RandomStringUtils.random(rnd.nextInt(120));
		String password = RandomStringUtils.random(rnd.nextInt(30));
		id = userService.registerUser(firstName, lastName, login, email, password,
				countryService.addCountry(CountryServiceTest.randomCountry()));
		User testUser = getUserByIdTest();
		
		Assert.assertNotNull(testUser);
		
		deleteUserByIdTest();
	}

	public void deleteUserByIdTest() {
		userService.deleteUserById(id);
	}

	public User getUserByIdTest() {
		return userService.getUserById(id);
	}

}
