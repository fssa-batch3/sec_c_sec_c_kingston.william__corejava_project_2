package com.fssa.blooddonation.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.blooddonation.Dao.BloodRequestDao;
import com.fssa.blooddonation.enums.BloodGroup;
import com.fssa.blooddonation.enums.RequestStatus;
import com.fssa.blooddonation.exception.ValidationException;
import com.fssa.blooddonation.logger.Logger;
import com.fssa.blooddonation.model.BloodRequest;
import com.fssa.blooddonation.validator.BloodReqValidator;

//This class is a test class for the RequestService class, used to test its methods.
class RequestServiceTest {
	// Creating an instance of the Logger class to log messages during testing.
	Logger logger = new Logger();

	// Creating an instance of the RequestService class to test its methods.
	// The RequestService constructor requires a BloodReqValidator and a
	// BloodRequestDao instance.
	RequestService rs = new RequestService(new BloodReqValidator(), new BloodRequestDao());

	BloodRequest bloodRequest = new BloodRequest("santhanam", 1, BloodGroup.A_NEGATIVE,  "need 7 unit", "7383705355",
			LocalDate.parse("2020-10-12"), true, RequestStatus.OPEN, null,1);
	// This test method checks the behavior of the createBloodReq method of the
	// RequestService class.

	@Test
	void createBloodReqTest() {
		// The assertDoesNotThrow method expects a lambda expression (Runnable)
		// representing the method call.
		assertDoesNotThrow(() -> rs.createBloodReq(bloodRequest));

	}

	@Test
	void createBloodReqTestInvalid() {
		// Creating a sample BloodRequest instance with invalid details for testing
		// purposes.
		BloodRequest bloodRequest = new BloodRequest("kingsman", 1, BloodGroup.A_NEGATIVE, "test", "1234562322",
				LocalDate.parse("2023-10-12"), true, RequestStatus.OPEN, null,1);

		// Using an assertion to ensure that a ValidationException is thrown when
		// attempting to create an invalid blood request.
		// The assertThrows method expects the expected exception class and a lambda
		// expression (Runnable) representing the method call.
		assertThrows(ValidationException.class, () -> rs.createBloodReq(bloodRequest));

	}

	@Test
	void updateBloodReq() throws ValidationException {
		BloodRequest bloodRequest = new BloodRequest("Rahul",20 ,BloodGroup.O_POSITIVE, "my friend was in serious condition need AB+ blood.", "9445708908",
				LocalDate.parse("2022-10-12"), true, RequestStatus.OPEN, null,1);
		// Using an assertion to ensure that the updateBloodReq method returns true for
		// a successful update.
		assertTrue(rs.updateBloodReq(bloodRequest));
	}

	@Test
	void getAllBloodReq() {
		// Retrieving all blood requests using the getAllBloodRequest method.
		ArrayList<BloodRequest> ar = rs.getAllBloodRequest();
		logger.info(ar);

		// Verifying if the ArrayList is not null.
		// If the ArrayList is not null, the test is considered successful, otherwise,
		// it fails.
		if (ar != null) {
			assertTrue(true);// test pass
		} else {
			Assertions.fail();// test fail
		}
	}

	@Test
	void deleteBloodReq() {
		// It verifies whether the method successfully deletes a blood request with the
		// specified ID.
		assertTrue(rs.deleteBloodReq(4));

	}

}
