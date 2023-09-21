package com.fssa.blooddonation.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.blooddonation.enums.BloodGroup;
import com.fssa.blooddonation.enums.Gender;
import com.fssa.blooddonation.logger.Logger;
import com.fssa.blooddonation.model.User;

public class UserDao {

	static Logger logger = new Logger();

	// Adds a new user to the database based on the provided User object.
	public boolean addUser(User user) throws SQLException  {
		try (Connection connection = ConnectionUtil.getConnection()) {
			// SQL query to insert a new user into the 'user' table.
			String query = "INSERT INTO user(name,phone_num,email_id,gender,bloodgroup,password) "
					+ "VALUES(?,?,?,?,?,?)";

			// Prepares the SQL query with the provided user details.
			try (PreparedStatement psmt = connection.prepareStatement(query)) {
				// Sets the user details in the PreparedStatement.
				psmt.setString(1, user.getName());
				psmt.setString(2, user.getPhoneNo());
				psmt.setString(3, user.getEmail());
				psmt.setString(4, user.getGender().getValue());
				psmt.setString(5, user.getBloodGroup().getValue());
				psmt.setString(6, user.getPassWord()); 
				

				// Executes the insert query and returns the number of rows affected.
				int rowAffected = psmt.executeUpdate();
 
				// Prints the number of rows affected by the insert query.
				logger.info(rowAffected + " row/rows affected");

		

			}

		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return true;
	}
	
//	public boolean updateUser(User user) throws SQLException {
//		try (Connection con = ConnectionUtil.getConnection()) {
//			// SQL query to insert a new user into the 'user' table.
//			String query = "UPDATE user set name=?,phone_num=?,email_id=?, bloodgroup =? where email_id=?";
//
//			// Prepares the SQL query with the provided user details.
//			try (PreparedStatement psmt = con.prepareStatement(query)) {
//				// Sets the user details in the PreparedStatement.
//				psmt.setString(1, user.getName());
//				psmt.setString(2, user.getPhoneNo());
//				psmt.setString(3, user.getEmail());
//				psmt.setString(4, user.getGender().getValue());
//				psmt.setString(5, user.getBloodGroup().getValue());
//				psmt.setString(6, user.getPassWord()); 
//	
//				// Executes the insert query and returns the number of rows affected.
//				int rowAffected = psmt.executeUpdate();
// 
//				// Prints the number of rows affected by the insert query.
//				logger.info(rowAffected + " row/rows affected");
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new SQLException(e.getMessage());
//			
//		}
//		return true;
//	}
//	
//}
	
	
	public User login(String email, String password) throws SQLException {

		try (Connection con = ConnectionUtil.getConnection()) {

			// SQL query to delete the user from the 'user' table.
			String query = "SELECT * FROM user WHERE email_id = ? AND password = ?";

			User user;
			// Prepares the SQL query with the user_id.
			try (PreparedStatement psmt = con.prepareStatement(query)) {

				// Sets the user_id in the PreparedStatement.
				psmt.setString(1, email);
				psmt.setString(2, password);

				// Executes the delete query.
				try (ResultSet rs = psmt.executeQuery()) {

					if (rs.next()) {
						user = new User();

						user.setName(rs.getString("name"));
						user.setPhoneNo(rs.getString("phone_num"));
						user.setEmail(rs.getString("email_id"));
						user.setGender(Gender.valueToEnumMapping(rs.getString("gender")));
						user.setBloodGroup(BloodGroup.valueToEnumMapping(rs.getString("bloodgroup")));
						user.setPassWord(rs.getString("password"));
						return user;
					}
				}

			}
			return null;

		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
