package com.fssa.donor.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {

		String url = "jdbc:mysql://localhost:3306/blood_donation";

		String username = "root";

		String password = "123456";

		Connection con = DriverManager.getConnection(url, username, password);
		
		return con;

	}
	
	public static void main(String[] args) throws SQLException {
		
		
		Connection con = getConnection();
		System.out.println(con);
	}
}