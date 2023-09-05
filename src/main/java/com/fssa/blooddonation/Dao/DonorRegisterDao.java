package com.fssa.blooddonation.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.blooddonation.logger.Logger;
import com.fssa.blooddonation.model.DonorRegister;

public class DonorRegisterDao {
public static void createDonorRegister(DonorRegister donorCreate) {
	try(Connection connection = ConnectionUtil.getConnection()){
		String query = "INSERT INTO donor(name,MobileNo,bloodtype,address,state,district,age,emailId,gender(?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = connection.prepareStatement(query)) {
			
			pst.setString(1, donorCreate.getName());
			pst.setString(2, donorCreate.getMobileNo());
			pst.setString(3, donorCreate.getBloodtype().getValue());
			pst.setString(4, donorCreate.getAddress());
			pst.setString(5, donorCreate.getState().getValue());
			pst.setString(6, donorCreate.getDistrict().getValue());
			
			
		}
	}
	 catch (SQLException e) {
			// Print any SQLException error messages
			Logger.info(e.getMessage());
		}
}
}
