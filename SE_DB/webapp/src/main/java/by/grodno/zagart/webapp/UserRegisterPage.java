package by.grodno.zagart.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import by.grodno.zagart.services.UserService;

public class UserRegisterPage {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext(
				"spring-context.xml");

		UserService userService = aContext.getBean(UserService.class);
		userService.registerUser("Ivan", "Ivanov", "iva.iva", "test@mail.com", "passwords");

	}
}
