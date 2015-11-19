package com.epam.training.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.services.UserService;

public class UserRegisterPage {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-context.xml");

		UserService bean = aContext.getBean(UserService.class);
		System.out.print(true);
	}
}