package com.fssa.BloodDonation.validator;

import java.time.LocalDate;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.BloodDonation.enums.BloodGroup;
import com.fssa.BloodDonation.model.BloodRequest;

public class BloodReqValidator {
	private static final String NUMBER_REGEX = "^[-+]?[0-9]+(\\.[0-9]+)?$";
	private static final LocalDate MIN_DATE = LocalDate.of(2020, 1, 1);
    private static final LocalDate MAX_DATE = LocalDate.now();

 // Define a public static method named "validateBloodRequest" that takes a BloodRequest object as a parameter
 // and can throw an IllegalArgumentException.
 public static boolean validateBloodRequest(BloodRequest bloodReqValidate) throws IllegalArgumentException {
     // Validate the ID of the BloodRequest by calling the "validateId" method and passing the ID from the input object.
     validateId(bloodReqValidate.getId());
     
     // Validate the blood type of the BloodRequest by calling the "validateBloodType" method and passing the blood type from the input object.
     validateBloodType(bloodReqValidate.getBloodtype());
     
     // Validate the description of the BloodRequest by calling the "validateDescription" method and passing the description from the input object.
     validateDescription(bloodReqValidate.getDescription());
     
     // Validate the contact number of the BloodRequest by calling the "validateContactNo" method and passing the contact number from the input object.
     validateContactNo(bloodReqValidate.getContactNo());
     
     // Validate the request date of the BloodRequest by calling the "validateReqDate" method and passing the request date from the input object.
     validateReqDate(bloodReqValidate.getReqDate());
     
     // Return true to indicate that all validation checks have passed.
     return true;
 }


//Define a public static method named "validateId" that takes an integer parameter "Id"
//and can throw an IllegalArgumentException.
public static boolean validateId(int Id) throws IllegalArgumentException {
  // Initialize a variable "idNo" with the value 1.
  int idNo = 1;
  
  // Check if the provided "Id" is greater than the predefined value "idNo".
  if (Id > idNo) {
      // If the condition is met, throw an IllegalArgumentException with a specific error message.
      throw new IllegalArgumentException("Id must be lesser than one");
  }
  
  // Return true to indicate that the validation check has passed.
  return true;
}


//Define a public static method named "validateBloodType" that takes a BloodGroup parameter "bloodtype"
//and can throw an IllegalArgumentException.
public static boolean validateBloodType(BloodGroup bloodtype) throws IllegalArgumentException {
 // Create a new instance of the BloodRequest class.
 BloodRequest req = new BloodRequest();
 
 // Iterate through all possible values of the BloodGroup enum using a for-each loop.
 for (BloodGroup grp : BloodGroup.values()) {
     // Check if the value of the current enum element "grp" is equal to the "bloodtype" from the input.
     if (grp.value.equals(req.getBloodtype())) {
         // If the condition is met, throw an IllegalArgumentException with a specific error message.
         throw new IllegalArgumentException("write the correct blood type");
     }
 }
 
 // Return true to indicate that the validation check has passed.
 return true;
}


//Define a public static method named "validateDescription" that takes a String parameter "description"
//and can throw an IllegalArgumentException.
public static boolean validateDescription(String description) throws IllegalArgumentException {
 // Check if the provided "description" is null or its length is less than 3 characters.
 if (description == null || description.length() < 3) {
     // If the condition is met, throw an IllegalArgumentException with a specific error message.
     throw new IllegalArgumentException("type the correct description");
 }
 
 // Return true to indicate that the validation check has passed.
 return true;
}

//Define a public static method named "validateContactNo" that takes a String parameter "ContactNo"
//and can throw an IllegalArgumentException.
public static boolean validateContactNo(String ContactNo) throws IllegalArgumentException {
 // Check if the provided "ContactNo" is null.
 if (ContactNo == null) {
     // If the condition is met, throw an IllegalArgumentException with a specific error message.
     throw new IllegalArgumentException("type the correct number");
 }
 
 // Use a regular expression pattern to match the provided "ContactNo" against a predefined pattern.
 // The "NUMBER_REGEX" variable should be defined elsewhere in your code.
 boolean match = Pattern.matches(NUMBER_REGEX, ContactNo);
 
 // Check if the "ContactNo" did not match the expected pattern.
 if (!match) {
     // If the condition is met, throw an IllegalArgumentException with a specific error message.
     throw new IllegalArgumentException("type the correct number");
 }
 
 // Return true to indicate that the validation check has passed.
 return true;
}

//Define a public static method named "validateReqDate" that takes a LocalDate parameter "reqDate"
//and can throw an IllegalArgumentException.
public static boolean validateReqDate(LocalDate reqDate) throws IllegalArgumentException {
 // Check if the provided "reqDate" is null.
 if (reqDate == null) {
     // If the condition is met, throw an IllegalArgumentException with a specific error message.
     throw new IllegalArgumentException("type the correct reqDate");
 }
 
 // Check if the "reqDate" is before the minimum date or after the maximum date.
 // The "MIN_DATE" and "MAX_DATE" constants should be defined elsewhere in your code. 
 if (reqDate.isBefore(MIN_DATE) || reqDate.isAfter(MAX_DATE)) {
     // If the condition is met, throw an IllegalArgumentException with a specific error message.
     throw new IllegalArgumentException("type the correct reqDate");
 }
 
 // Return true to indicate that the validation check has passed.
 return true;
}


	
	
}