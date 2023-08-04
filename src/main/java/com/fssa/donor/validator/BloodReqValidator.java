package com.fssa.donor.validator;

import java.time.LocalDate;
import java.util.regex.Pattern;

import com.fssa.donor.enums.BloodGroup;
import com.fssa.donor.model.BloodRequest;

public class BloodReqValidator {
	private static final String NUMBER_REGEX = "^[-+]?[0-9]+(\\.[0-9]+)?$";

	public void validate(BloodRequest bloodReqValidate) throws IllegalArgumentException {
		validateId(bloodReqValidate.getId());
		validateBloodType(bloodReqValidate.getBloodtype());
		validateDescription(bloodReqValidate.getDescription());
		validateContactNo(bloodReqValidate.getContactNo());
		validateReqDate(bloodReqValidate.getDate());
	}  

	public static boolean validateId(int Id) throws IllegalArgumentException {
		if (Id > 1) {
			throw new IllegalArgumentException("Id must be lesser than one");
		}
		return true;
	}

	public static boolean validateBloodType(String bloodtype) throws IllegalArgumentException {
		BloodRequest req = new BloodRequest();
		for (BloodGroup grp : BloodGroup.values()) {
			if (grp.value.equals(req.getBloodtype())) {
				System.out.println("eneum and the user given value are matched");
			}
		}
		return true;
	}

	public static boolean validateDescription(String description) throws IllegalArgumentException {
		if (description == null || description.length() > 3) {

		}
		return true;
	}

	public static boolean validateContactNo(String ContactNo) throws IllegalArgumentException {
		if (ContactNo == null || Pattern.matches(NUMBER_REGEX, ContactNo)) {
			throw new IllegalArgumentException("type the correct number");

		}
		return true;
	}

	public static boolean validateReqDate(LocalDate reqDate) throws IllegalArgumentException {
		LocalDate today = LocalDate.now();
		if (reqDate != today) {
			throw new IllegalArgumentException("Enter the correct Date");
		}
		return true;
	}

	
	public static boolean validateModDate(LocalDate closedDate) throws IllegalArgumentException {
		LocalDate today = LocalDate.now();
		if (closedDate != today) {
			throw new IllegalArgumentException("Enter the correct Date");
		}
		return true;
	}
	public static boolean validateReqVerification(boolean reqVerification, BloodRequest bloodReqValidate) throws IllegalArgumentException{
		if(validateBloodType(bloodReqValidate.getBloodtype()) && validateDescription(bloodReqValidate.getDescription()) &&
				validateContactNo(bloodReqValidate.getContactNo())) {
			return true;
		}
		return false;
		
	}
	
	
}