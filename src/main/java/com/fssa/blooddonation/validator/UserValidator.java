package com.fssa.blooddonation.validator;

import java.util.regex.Pattern;

import com.fssa.blooddonation.enums.BloodGroup;
import com.fssa.blooddonation.enums.DonorBloodGroup;
import com.fssa.blooddonation.enums.Gender;
import com.fssa.blooddonation.exception.ValidationException;
import com.fssa.blooddonation.model.DonorRegister;
import com.fssa.blooddonation.model.User;


public class UserValidator {
	public static final String NUMBER_REGEX = "^[-+]?[0-9]+(\\.[0-9]+)?$";
	  public static String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
	public static boolean validateUser(User userValidate) throws ValidationException {
		validateName(userValidate.getName());
		validatePhoneNo(userValidate.getPhoneNo());
		validateEmail(userValidate.getEmail());
		validateGender(userValidate.getGender());
		validateBloodType(userValidate.getBloodGroup());
		validatePassword(userValidate.getPassWord());
	return true;
	}
	public static boolean validateName(String name) throws ValidationException {
	    // Check if the provided name is not null or empty.
	    if (name == null || name.isEmpty()) {
	        // If the condition is met, throw a ValidationException with a specific error message.
	        throw new ValidationException("Name cannot be null or empty");
	    }

	    // Check if the name contains only letters and spaces.
	    if (!name.matches("^[a-zA-Z\\s]+$")) {
	        // If the condition is met, throw a ValidationException with a specific error message.
	        throw new ValidationException("Name must contain only letters and spaces");
	    }

	    // Check if the name length is within a reasonable range.
	    if (name.length() < 2 || name.length() > 50) {
	        // If the condition is met, throw a ValidationException with a specific error message.
	        throw new ValidationException("Name length must be between 2 and 50 characters");
	    }

	    // If all checks pass, return true to indicate that the validation check has passed.
	    return true;
	}
	
	public static boolean validatePhoneNo(String phoneNo) throws ValidationException {
		// Check if the provided "ContactNo" is null.
		if (phoneNo == null) {
			// If the condition is met, throw an IllegalArgumentException with a specific
			// error message.
			throw new ValidationException("type the correct number");
		}

		// Use a regular expression pattern to match the provided "ContactNo" against a
		// predefined pattern.
		// The "NUMBER_REGEX" variable should be defined elsewhere in your code.
		boolean match = Pattern.matches(NUMBER_REGEX, phoneNo);

		// Check if the "ContactNo" did not match the expected pattern.
		if (!match) {
			// If the condition is met, throw an IllegalArgumentException with a specific
			// error message.
			throw new ValidationException("type the correct number");
		}

		// Return true to indicate that the validation check has passed.
		return true;
	}
	
	public static boolean validateEmail(String emailId) throws ValidationException {
	    // Define a regular expression pattern for a valid email address
	 

	    // Use the Pattern class to compile the regular expression
	    Pattern pattern = Pattern.compile(emailRegex);
	    System.out.println(emailId);

	    // Use the Matcher class to perform the matching
	    if (emailId == null || !pattern.matcher(emailId).matches()) {
	        throw new ValidationException("Invalid email address format");
	    }

	    // Return true to indicate that the validation check has passed
	    return true;
	}
	
	public static boolean validateGender(Gender gender) throws ValidationException {
	    // Assuming DonorGender is an enum representing valid genders

	    // Create a boolean flag to check if the provided gender is valid
	    boolean isValidGender = false;
	    System.out.println(gender);
	    // Iterate through all possible values of the DonorGender enum using a for-each loop
	    for (Gender validGender : Gender.values()) {
	        // Check if the value of the current enum element "validGender" is equal to the "gender" from the input
	        if (validGender.equals(gender)) {
	            isValidGender = true;
	            break; // Exit the loop when a valid gender is found
	        }
	    }

	    // If the provided gender is not found in the enum values, it's invalid
	    if (!isValidGender) {
	        throw new ValidationException("Invalid gender");
	    }

	    // Return true to indicate that the validation check has passed
	    return true;
	}
	
	public static boolean validateBloodType(BloodGroup donorBloodGroup) throws ValidationException {
		// Create a new instance of the BloodRequest class.
		DonorRegister req = new DonorRegister();

		// Iterate through all possible values of the BloodGroup enum using a for-each
		// loop.
		for (BloodGroup grp : BloodGroup.values()) {
			// Check if the value of the current enum element "grp" is equal to the
			// "bloodtype" from the input.
			if (grp.value.equals(req.getBloodtype())) {
				// If the condition is met, throw an IllegalArgumentException with a specific
				// error message.
				throw new ValidationException("write the correct blood type");
			}
		}

		// Return true to indicate that the validation check has passed.
		return true;
	}
	
	public static boolean validatePassword(String password) throws ValidationException {
	    // Minimum and maximum length validation
	    int minLength = 8;
	    int maxLength = 20;
	    
	    if (password.length() < minLength || password.length() > maxLength) {
	        throw new ValidationException("Password length must be between " + minLength + " and " + maxLength + " characters.");
	    }
	    
	    // Uppercase letter validation
	    if (!password.matches(".*[A-Z].*")) {
	        throw new ValidationException("Password must contain at least one uppercase letter.");
	    }
	    
	    // Lowercase letter validation
	    if (!password.matches(".*[a-z].*")) {
	        throw new ValidationException("Password must contain at least one lowercase letter.");
	    }
	    
	    // Digit validation
	    if (!password.matches(".*\\d.*")) {
	        throw new ValidationException("Password must contain at least one digit.");
	    }
	    
	    // Special character validation (you can customize this regex as needed)
	    if (!password.matches(".*[!@#$%^&*()-_+=<>?].*")) {
	        throw new ValidationException("Password must contain at least one special character.");
	    }
	    
	    // No spaces validation
	    if (password.contains(" ")) {
	        throw new ValidationException("Password cannot contain spaces.");
	    }
	    
	    // Additional custom rules can be added here
	    
	    // If all validations pass, return true
	    return true;
	}

}
