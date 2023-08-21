package com.fssa.BloodDonation.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.BloodDonation.Dao.BloodRequestDao;
import com.fssa.BloodDonation.enums.BloodGroup;
import com.fssa.BloodDonation.enums.RequestStatus;
import com.fssa.BloodDonation.model.BloodRequest;
import com.fssa.BloodDonation.validator.BloodReqValidator;

public class RequestServiceTest {


	RequestService rs = new RequestService(new BloodReqValidator(), new BloodRequestDao());
	
	BloodRequest bloodRequest = new BloodRequest(BloodGroup.A_NEGATIVE, "test", "9080668509",
			LocalDate.parse("2020-10-12"), true, RequestStatus.OPEN, null);
	@Test
	public void createBloodReqTest() {

		assertDoesNotThrow(() -> rs.createBloodReq(bloodRequest));

	}  
	
	@Test
	public void createBloodReqTestInvalid() { 
		
		BloodRequest bloodRequest = new BloodRequest(BloodGroup.A_NEGATIVE, "test", "1234562893",
				LocalDate.parse("2023-10-12"), true, RequestStatus.OPEN, null);
		
		assertThrows(IllegalArgumentException.class,()->rs.createBloodReq(bloodRequest));

	}
	
	@Test
	public void updateBloodReq() {
		BloodRequest bloodRequest = new BloodRequest(BloodGroup.A_NEGATIVE, "check", "1234562893",
				LocalDate.parse("2022-10-12"), true, RequestStatus.OPEN, null);
		
		assertTrue(rs.updateBloodReq(bloodRequest));
	}
	
	@Test
	public void getAllBloodReq() { 
		ArrayList<BloodRequest> ar = rs.getAllBloodRequest();
		
		if(ar!=null) {
			assertTrue(true);
		}
		else {
			Assertions.fail();
		}
	} 
	
	@Test
	public void deleteBloodReq (){

		assertTrue(rs.deleteBloodReq(bloodRequest));
		
		
	} 
}
