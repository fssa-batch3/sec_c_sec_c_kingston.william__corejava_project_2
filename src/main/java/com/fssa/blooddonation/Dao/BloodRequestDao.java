package com.fssa.blooddonation.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fssa.blooddonation.enums.BloodGroup;
import com.fssa.blooddonation.enums.RequestStatus;
import com.fssa.blooddonation.logger.Logger;
import com.fssa.blooddonation.model.BloodRequest;

public class BloodRequestDao {
	public static void createBloodReq(BloodRequest bloodCreate) {
		// Write code here to get connection

		// Try-with-resources block to automatically close the connection
		try (Connection connection = ConnectionUtil.getConnection()) {
			// Create insert statement
			String query = "INSERT INTO bloodrequest (bloodType,description,contactNo,reqDate,reqVerification,status,name, quantity) VALUES ( ?, ?, ?, ?, ?, ?, ?,?)";

			// Create prepared statement for the insert query
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				// Set parameters for the prepared statement
				pst.setString(1, bloodCreate.getBloodtype().getValue());
				pst.setString(2, bloodCreate.getDescription());
				pst.setString(3, bloodCreate.getContactNo());

				// Convert Java LocalDate to SQL Date and set as parameter
				java.sql.Date reqDate = Date.valueOf(bloodCreate.getReqDate());//TODO//LocalDate.now().getDate()
				pst.setDate(4, reqDate);

				// Convert verification boolean to string and set as parameter
				pst.setString(5, bloodCreate.getVerification() ? "True" : "False");

				// Set status value as parameter
				pst.setString(6, bloodCreate.getStatus().getValue());

				// Set null value for closedDate parameter
				
				pst.setString(7, bloodCreate.getName());
				pst.setInt(8, bloodCreate.getQuantity());
				

				// Execute the insert statement

				pst.executeUpdate();

				// Close the connection
				connection.close();

				// Log successful blood request addition
				Logger.info("Blood request is added successfully ");
			}

		} catch (SQLException e) {
			// Print any SQLException error messages
			Logger.info(e.getMessage());
		}
	}

	public static void updateBloodReqDao(BloodRequest bloodUpdate) {
		// Write code here to get connection

		// Try-with-resources block to automatically close the connection
		try (Connection connection = ConnectionUtil.getConnection()) {
			// Create update statement
			String query = "UPDATE bloodrequest SET bloodType = ?, description = ?, contactNo = ?, reqDate = ?, reqVerification = ?, status = ?, name=?, quantity=? WHERE id = ?";

			// Create prepared statement for the update query
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				// Set parameters for the prepared statement
				pst.setString(1, bloodUpdate.getBloodtype().getValue());
				pst.setString(2, bloodUpdate.getDescription());
				pst.setString(3, bloodUpdate.getContactNo());

				// Convert Java LocalDate to SQL Date and set as parameter
				java.sql.Date reqDate = Date.valueOf(bloodUpdate.getReqDate());
				pst.setDate(4, reqDate);

				// Convert verification boolean to string and set as parameter
				pst.setString(5, bloodUpdate.getVerification() ? "True" : "False");

				// Set status value as parameter
				pst.setString(6, bloodUpdate.getStatus().getValue());
				pst.setString(7, bloodUpdate.getName());
				pst.setInt(8, bloodUpdate.getQuantity());
				// Set ID value as parameter for the WHERE clause
				pst.setInt(9, getIdByContactNo(bloodUpdate.getContactNo()));

				// Execute the update statement
				pst.executeUpdate();

				// Close the connection
				connection.close();

				// Log successful blood request update
				Logger.info("Blood request is updated successfully ");
			}
		} catch (SQLException e) {
			// Print any SQLException error messages
			Logger.info(e.getMessage());
		}
	}

	public static int getIdByContactNo(String no) {

		// Try-with-resources block to automatically close the connection
		try (Connection connection = ConnectionUtil.getConnection()) {
			// Create update statement
			String query = "SELECT id FROM bloodrequest WHERE contactNo =?";

			// Create prepared statement for the update query
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				// Set parameters for the prepared statement
				pst.setString(1, no);

				ResultSet rs = pst.executeQuery();

				int id = 0;
				while (rs.next()) {
					id = rs.getInt("id");
				}
				// Close the connection
				connection.close();
				Logger.info("Fetched id successfully by contact no " + no + " " + id);
				return id;

			}
		} catch (SQLException e) {
			// Print any SQLException error messages
			Logger.info(e.getMessage());
		}
		return 0;
	}

	public static ArrayList<BloodRequest> getAllBloodRequest() throws IllegalArgumentException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			// SQL query to select all rows from the bloodrequest table
			String selectQuery = "SELECT * FROM bloodrequest";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				try (ResultSet rs = psmt.executeQuery()) {
					// Create an ArrayList to store BloodRequest objects
					ArrayList<BloodRequest> bloodReqList = new ArrayList<BloodRequest>();

					// Loop through the result set to retrieve each row's data
					while (rs.next()) {
						// Create a new BloodRequest object for each row
						BloodRequest request = new BloodRequest();

						// Set properties of the BloodRequest object using data from the result set
						request.setId(rs.getInt("id"));
						request.setName(rs.getString("name"));
						request.setQuantity(rs.getInt("quantity"));
						request.setBloodtype(BloodGroup.valueToEnumMapping(rs.getString("bloodType")));
						request.setDescription(rs.getString("description"));
						request.setContactNo(rs.getString("contactNo"));
						request.setReqDate(rs.getDate("reqDate").toLocalDate());

						// Convert "reqVerification" column to boolean value
						request.setVerification(rs.getString("reqVerification").equals("True") ? true : false);

						// Set the status property using data from the result set
						request.setStatus(RequestStatus.valueToEnumMapping(rs.getString("status")));

						// Add the populated BloodRequest object to the ArrayList
						bloodReqList.add(request);
					}

					// Return the ArrayList containing BloodRequest objects
					return bloodReqList;
				}
			}
		} catch (SQLException e) {
			// Throw an exception with an error message if a SQL error occurs
			throw new IllegalArgumentException("Error while reading bloodrequest: " + e.getMessage());
		}
	}

//	delete
	public static boolean deleteBloodReq(int id) throws IllegalArgumentException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			// Create the DELETE query
			String deleteQuery = "DELETE FROM bloodrequest WHERE id=?";

			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {
				// Set the id as the parameter for the DELETE query
				psmt.setInt(1, id);

				// Execute the delete statement and get the number of affected rows
				int rowAffected = psmt.executeUpdate();

				Logger.info("Blood request id deleted successfully");
				// Return true if at least one row was affected (deleted), false otherwise
				return rowAffected > 0;
			}
		} catch (SQLException e) {
			// Throw an exception with an error message if a SQL error occurs
			throw new IllegalArgumentException("Error while deleting request: " + e.getMessage());
		}
	}
}