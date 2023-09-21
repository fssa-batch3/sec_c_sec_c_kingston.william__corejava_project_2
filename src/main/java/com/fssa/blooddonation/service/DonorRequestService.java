package com.fssa.blooddonation.service;

import java.util.ArrayList;

import com.fssa.blooddonation.Dao.DonorRegisterDao;
import com.fssa.blooddonation.exception.ValidationException;
import com.fssa.blooddonation.logger.Logger;
import com.fssa.blooddonation.model.DonorRegister;
import com.fssa.blooddonation.validator.DonorValidator;

public class DonorRequestService {

	private DonorValidator donorValidator; // Reference to a BloodReqValidator instance
	private DonorRegisterDao donorRegisterDao; // Reference to a BloodRequestDao instance

	public DonorRequestService(DonorValidator donorValidator, DonorRegisterDao donorRegisterDao) {
		this.donorValidator = donorValidator; // Initialize the DAO reference
		this.donorRegisterDao = donorRegisterDao; // Initialize the validator reference
	}

	public boolean createDonorRegister(DonorRegister donorRegister) throws ValidationException {

		if (donorValidator.validateDonorRequest(donorRegister)) {

			donorRegisterDao.createDonorRegister(donorRegister);
			Logger.info("Donor request is created Successfully");
			return true;
		}
 
		return false;
	}
	// getAllDonorRequests

	public ArrayList<DonorRegister> getAllDonorRequests() throws ValidationException {

		return donorRegisterDao.getAllDonorDetails(); 
		
	}
	
	// method to delete donor request
	public boolean deleteDonorReg(String email) {
		return DonorRegisterDao.deleteDonorReg(email);
	}
}
