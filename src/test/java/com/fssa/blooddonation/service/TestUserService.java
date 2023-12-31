package com.fssa.blooddonation.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.blooddonation.Dao.UserDao;
import com.fssa.blooddonation.enums.BloodGroup;
import com.fssa.blooddonation.enums.Gender;
import com.fssa.blooddonation.exception.ValidationException;
import com.fssa.blooddonation.model.User;
import com.fssa.blooddonation.validator.UserValidator;

public class TestUserService {

	static User validateUSer() {
		User user = new User();
	
		user.setName("helloguys");
		user.setEmail("kingston@gmail.com");
		user.setBloodGroup(BloodGroup.A_NEGATIVE);
		user.setPhoneNo("6383705215");
		user.setGender(Gender.MALE);
		user.setPassWord("King@1234");
		return user;

	}

	UserService userService = new UserService(new UserValidator(), new UserDao());

	@Test
	public void testAddUser() {
 
		try {
			Assertions.assertTrue(userService.addUser(validateUSer()));
		} catch (SQLException | ValidationException e) {
			Assertions.fail();
			e.printStackTrace();
		}

	}

	@Test
	void testValidUpdateUser() throws SQLException, ValidationException {
		TestUserService testUser = new TestUserService();

		Assertions.assertTrue(UserService.updateUser(validateUSer()));
	}

}
