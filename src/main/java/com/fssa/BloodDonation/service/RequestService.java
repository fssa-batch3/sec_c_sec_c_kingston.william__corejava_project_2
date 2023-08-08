package com.fssa.BloodDonation.service;

import java.util.ArrayList;

import com.fssa.BloodDonation.Dao.BloodRequestDao;
import com.fssa.BloodDonation.model.BloodRequest;
import com.fssa.BloodDonation.validator.BloodReqValidator;

public class RequestService {

	private BloodReqValidator bloodReqValidator; // Reference to a BloodReqValidator instance
	private BloodRequestDao requestDao; // Reference to a BloodRequestDao instance

	// Constructor to initialize the RequestService with validator and DAO instances
	public RequestService(BloodReqValidator bloodReqValidator, BloodRequestDao requestDao) {
		this.requestDao = requestDao; // Initialize the DAO reference
		this.bloodReqValidator = bloodReqValidator; // Initialize the validator reference
	}

	// Method to create a blood request
	public boolean createBloodReq(BloodRequest bloodRequest) throws IllegalArgumentException {
		// Validate the blood request using the validator
		if (bloodReqValidator.validateBloodRequest(bloodRequest)) {
			// If validation succeeds, create the blood request using the DAO
			requestDao.createBloodReq(bloodRequest);
		}

		// Return true to indicate successful execution (may need more refined logic)
		return true;
	}

	// Method to update a blood request
	public boolean updateBloodReq(BloodRequest bloodRequest) {
		// Validate the blood request using the validator
		if (bloodReqValidator.validateBloodRequest(bloodRequest)) {
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
	public boolean deleteBloodReq(BloodRequest bloodRequest) {

		return requestDao.deleteBloodReq(bloodRequest);
	}

}
