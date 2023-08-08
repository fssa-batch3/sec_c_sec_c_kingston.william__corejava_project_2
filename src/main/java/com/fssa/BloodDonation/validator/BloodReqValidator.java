package com.fssa.BloodDonation.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.BloodDonation.enums.BloodGroup;
import com.fssa.BloodDonation.model.BloodRequest;

public class BloodReqValidator {
	private static final String NUMBER_REGEX = "^[-+]?[0-9]+(\\.[0-9]+)?$";
	private static final LocalDate MIN_DATE = LocalDate.of(2020, 1, 1);
    private static final LocalDate MAX_DATE = LocalDate.now();

	public  static boolean validateBloodRequest(BloodRequest bloodReqValidate) throws IllegalArgumentException {
		validateId(bloodReqValidate.getId());
		validateBloodType(bloodReqValidate.getBloodtype());
		validateDescription(bloodReqValidate.getDescription());
		validateContactNo(bloodReqValidate.getContactNo());
		validateReqDate(bloodReqValidate.getReqDate());
		return true;
	}   

	public static boolean validateId(int Id) throws IllegalArgumentException {
		int idNo=1;
		if (Id > idNo) {
			throw new IllegalArgumentException("Id must be lesser than one");
		}
		return true; 
	}

	public static boolean validateBloodType(BloodGroup bloodtype) throws IllegalArgumentException {
		BloodRequest req = new BloodRequest();
		for (BloodGroup grp : BloodGroup.values()) {
			if (grp.value.equals(req.getBloodtype())) {
				System.out.println("eneum and the user given value are matched");
			}
		}
		return true; 
	}

	public static boolean validateDescription(String description) throws IllegalArgumentException {
		if (description == null || description.length() < 3) {
throw new IllegalArgumentException ("type the correct description");
		}
		return true;
	}

	public static boolean validateContactNo(String ContactNo) throws IllegalArgumentException {
		
		if (ContactNo == null) {
			throw new IllegalArgumentException("type the correct number");

		}
		boolean match = Pattern.matches(NUMBER_REGEX, ContactNo);
		if(!match) {
			throw new IllegalArgumentException("type the correct number");
		}
		return true;
	}

	public static boolean validateReqDate(LocalDate reqDate) throws IllegalArgumentException {
		
		if(reqDate == null ) {
			throw new IllegalArgumentException("type the correct reqDate");
		}
		if (reqDate.isBefore(MIN_DATE) ||reqDate.isAfter(MAX_DATE)) {
			throw new IllegalArgumentException("type the correct reqDate");
		}
		return false;
		 
	}


	
	
}