package com.fssa.DonorRequestService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.blooddonation.Dao.DonorRegisterDao;
import com.fssa.blooddonation.enums.DonorBloodGroup;
import com.fssa.blooddonation.enums.DonorDistrict;
import com.fssa.blooddonation.enums.Gender;
import com.fssa.blooddonation.enums.DonorState;
import com.fssa.blooddonation.exception.ValidationException;
import com.fssa.blooddonation.logger.Logger;
import com.fssa.blooddonation.model.DonorRegister;
import com.fssa.blooddonation.service.DonorRequestService;
import com.fssa.blooddonation.validator.DonorValidator;

public class RegisterServiceTest {
Logger logger = new Logger();

DonorRequestService rs = new DonorRequestService(new DonorValidator(), new DonorRegisterDao());

DonorRegister donorRegister= new DonorRegister("Aravind", "9941568557", DonorBloodGroup.A_NEGATIVE, "#166,kavangarai retti street", DonorState.TAMIL_NADU, DonorDistrict.CHENNAI, 21, 
		                      "aravind@gmail.com",Gender.MALE);

@Test
void createDonorRegTest() {
	// The assertDoesNotThrow method expects a lambda expression (Runnable)
	// representing the method call.
	assertDoesNotThrow(() -> rs.createDonorRegister(donorRegister));

}


@Test
void getAllDonorRequests() throws ValidationException {
	// Retrieving all blood requests using the getAllBloodRequest method.
	ArrayList<DonorRegister> ar = rs.getAllDonorRequests();
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
void deleteDonorReg() {
	// It verifies whether the method successfully deletes a blood request with the
	// specified ID.
	assertTrue(rs.deleteDonorReg("Arun@gmail.com"));

}
}
