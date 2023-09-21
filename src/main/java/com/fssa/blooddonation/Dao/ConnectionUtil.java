package com.fssa.blooddonation.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	public static Connection getConnection() {
		Connection con = null;

		String url, userName, passWord;

		url = System.getenv("DATABASE_HOST");
		userName = System.getenv("DATABASE_USERNAME");
		passWord = System.getenv("DATABASE_PASSWORD");
//		url = "jdbc:mysql://localhost:3306/blood_donation";
//		userName = "root";
//		passWord = "123456";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database");
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con =getConnection();
		System.out.println("jhgv");
	}

}
