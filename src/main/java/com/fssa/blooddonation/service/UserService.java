package com.fssa.blooddonation.service;

import java.sql.SQLException;

import com.fssa.blooddonation.Dao.UserDao;
import com.fssa.blooddonation.exception.ValidationException;
import com.fssa.blooddonation.model.User;
import com.fssa.blooddonation.validator.UserValidator;

public class UserService {
	private static UserValidator userValidator;
	private static UserDao userDAO;
	// Constructor for the PlantService class
	public UserService(UserValidator userValidator, UserDao userDAO) {
		this.userValidator=userValidator;
		this.userDAO= userDAO;
	}
	


	public boolean addUser(User user) throws SQLException, ValidationException  {
		if (UserValidator.validateUser(user)) {
			userDAO.addUser(user);
		}
		return true;
	}
	public User login(String email, String password) throws SQLException, ValidationException {

		User user = null;
		if (userValidator.validateEmail(email)&&userValidator.validatePassword(password)) {
			user = userDAO.login(email, password);
		}

		return user;
	}
}
	