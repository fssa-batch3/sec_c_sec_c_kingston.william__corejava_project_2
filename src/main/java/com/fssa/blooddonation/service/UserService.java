package com.fssa.blooddonation.service;

import java.sql.SQLException;

import com.fssa.blooddonation.Dao.UserDao;
import com.fssa.blooddonation.exception.ValidationException;
import com.fssa.blooddonation.logger.Logger;
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
	


	public UserService() {
		// TODO Auto-generated constructor stub
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
	
//	update 
	public static boolean updateUser(User user) throws SQLException, ValidationException {
		// Check if the user is valid based on the userValidator
		
		if (!UserDao.isUserExist(user)) {

			throw new SQLException("User Not exists");
		}
		if (UserValidator.validateName(user.getName()) && UserValidator.validatePhoneNo(user.getPhoneNo())
				&& UserValidator.validateBloodType(user.getBloodGroup()) && UserValidator.validateEmail(user.getEmail()) && UserValidator.validateGender(user.getGender())) {
			// Check if the user already exists in the database
			UserDao.updateUser(user);
			Logger.info("User is updated to DB successfully!");
			return true;
		}

		return false; 
	}
}
	