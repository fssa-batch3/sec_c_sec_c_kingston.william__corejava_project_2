package com.fssa.blooddonation.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.blooddonation.enums.BloodGroup;
import com.fssa.blooddonation.enums.Gender;
import com.fssa.blooddonation.logger.Logger;
import com.fssa.blooddonation.model.User;

public class UserDao {

	static Logger logger = new Logger();

	// Adds a new user to the database based on the provided User object.
	public boolean addUser(User user) throws SQLException {
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

	// getall user
	public static List<String> getAllUserEmails() throws SQLException {

		// ArrayList to store the user email addresses.
		List<String> userNames = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnection()) {
			// SQL query to retrieve all email addresses from the 'user' table.
			String query = "SELECT email_id FROM user";

			// Creates a Statement object to execute the query.
			try (Statement smt = con.createStatement()) {

				// Executes the query and retrieves the results in a ResultSet.
				try (ResultSet resultSet = smt.executeQuery(query)) {

					// Iterates through the ResultSet and adds each email to the ArrayList.
					while (resultSet.next()) {
						userNames.add(resultSet.getString(1));
					}
				}
			}

		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}

		return userNames;
	}

	// get user by email.
	// Retrieves the user_id of a user based on their name from the 'user' table.
	public static int getUserIdByEmail(String email) throws SQLException {

		int userId = -1;

		try (Connection con = ConnectionUtil.getConnection()) {
			// SQL query to retrieve the user_id based on the user's name.
			String query = "SELECT user_id FROM user where email_id=?";

			// Prepares the SQL query with the provided user name.
			try (PreparedStatement psmt = con.prepareStatement(query)) {

				// Sets the user name in the PreparedStatement.
				psmt.setString(1, email);

				// Executes the query and retrieves the results in a ResultSet.
				try (ResultSet rs = psmt.executeQuery();) {

					// Retrieves the user_id from the ResultSet.
					while (rs.next()) {
						userId = rs.getInt("user_id");
					}

					return userId;
				}

			}

		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	// Get User by Email
	public static User getUserByEmail(String email) throws SQLException {
		User user = null; // Default value if the email is not found or an error occurs.
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT name, phone_num, email_id, gender, bloodgroup FROM user WHERE email_id=?";
			try (PreparedStatement psmt = con.prepareStatement(query)) {
				psmt.setString(1, email);
				System.out.println(psmt);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						user = new User();
						user.setName(rs.getString("name"));
						user.setPhoneNo(rs.getString("phone_num"));
						user.setEmail(rs.getString("email_id"));
						user.setGender(Gender.valueToEnumMapping(rs.getString("gender")));
						user.setBloodGroup(BloodGroup.valueToEnumMapping(rs.getString("bloodgroup")));
					}
				}
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return user;
	}

//	update user
	public static boolean updateUser(User user) throws SQLException{
		try (Connection con = ConnectionUtil.getConnection()) {
			final String query = "UPDATE user set name = ?, phone_num = ?, email_id = ?, gender= ?, bloodgroup=?  WHERE email_id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, user.getName());
				pst.setString(2, user.getPhoneNo());
				pst.setString(3, user.getEmail());
				pst.setString(4, user.getGender().getValue());
				pst.setString(4, user.getBloodGroup().getValue());
				pst.setInt(5, getUserIdByEmail(user.getEmail()));
				int rowAffected = pst.executeUpdate();
				logger.info(rowAffected + " row/rows affected");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
			
		}
		return true;
	}
	
	// Checks if a user with the provided details exists in the 'user' table.
		public static boolean isUserExist(User user) throws SQLException {
			// Retrieves all user email addresses from the 'user' table.
			List<String> userEmails = getAllUserEmails();
			Logger.info(userEmails);
			// Checks if the provided user's email is in the list of user emails.
			return userEmails.contains(user.getEmail());
		}
}
