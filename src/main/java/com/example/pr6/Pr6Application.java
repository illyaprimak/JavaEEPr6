package com.example.pr6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Pr6Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Pr6Application.class, args);

		UserService userService = applicationContext.getBean(UserService.class);
		UserEntity user = userService.createUser("firstName1", "lastName1", "email1@example.com");
		userService.createUser("Illya", "Prymachenko", "illyaprimak@gmail.com");
		userService.createUser("John", "Johnson", "johnjohn@gmail.com");
		userService.createUser("Vasya", "Pupkin", "vasya94@gmail.com");
		userService.createUser("Bill", "Brown", "bill@gmail.com");
		System.out.println("All users: " + userService.findAllUsers());
		System.out.println("Users with surname Brown: " + userService.findByName("Brown"));
		System.out.println("Users with letter a: " + userService.findAUsers("a"));
		System.out.println("Saved new user: " + user);

	}

}
