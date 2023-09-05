package com.fssa.blooddonation.service;

import java.util.ArrayList;

import com.fssa.blooddonation.Dao.BloodRequestDao;
import com.fssa.blooddonation.exception.ValidationException;
import com.fssa.blooddonation.model.BloodRequest;
import com.fssa.blooddonation.validator.BloodReqValidator;

public class RequestService {

	private BloodReqValidator bloodReqValidator; // Reference to a BloodReqValidator instance
	private BloodRequestDao requestDao; // Reference to a BloodRequestDao instance

	// Constructor to initialize the RequestService with validator and DAO instances
	public RequestService(BloodReqValidator bloodReqValidator, BloodRequestDao requestDao) {
		this.requestDao = requestDao; // Initialize the DAO reference
		this.bloodReqValidator = bloodReqValidator; // Initialize the validator reference
	}

	public RequestService() {
		// TODO Auto-generated constructor stub
	}

	// Method to create a blood request   
	public boolean createBloodReq(BloodRequest bloodRequest) throws ValidationException {
		// Validate the blood request using the validator
		if (bloodReqValidator.validateBloodRequest(bloodRequest)) {
			// If validation succeeds, create the blood request using the DAO
			requestDao.createBloodReq(bloodRequest);
		} 
 
		// Return true to indicate successful execution (may need more refined logic)
		return false;
	}

	// Method to update a blood request
	public boolean updateBloodReq(BloodRequest bloodRequest) throws ValidationException {
		// Validate the blood request using the validator
		if (BloodReqValidator.validateBloodRequest(bloodRequest)) {
			// If validation succeeds, update the blood request using the DAO
			requestDao.updateBloodReqDao(bloodRequest);
		}

		// Return true to indicate successful execution (may need more refined logic)
		return true;
	}

	public ArrayList<BloodRequest> getAllBloodRequest() {

		// If validation succeeds, get all the blood request using the DAO
		return requestDao.getAllBloodRequest();

		// Return true to indicate successful execution (may need more refined logic)

	}

	// Method to delete blood request
	public boolean deleteBloodReq(int id) {

		return BloodRequestDao.deleteBloodReq(id);
	}

}
