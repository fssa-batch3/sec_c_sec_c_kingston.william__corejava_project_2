package com.fssa.blooddonation.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.blooddonation.enums.BloodGroup;
import com.fssa.blooddonation.exception.ValidationException;
import com.fssa.blooddonation.model.BloodRequest;
import com.fssa.blooddonation.validator.BloodReqValidator;

class BloodReqValidatorTest {

	@Test
	void testValidBloodRequest() throws ValidationException {
		BloodRequest validRequest = new BloodRequest();
		validRequest.setId(2);
		validRequest.setName("name");
		validRequest.setQuantity(5);
		validRequest.setBloodtype(BloodGroup.A_POSITIVE); // Assuming BloodGroup enum exists
		validRequest.setDescription("Valid description");
		validRequest.setContactNo("1234567890");
		validRequest.setReqDate(LocalDate.of(2023, 8, 10));

		assertTrue(BloodReqValidator.validateBloodRequest(validRequest));
	}

	@Test
	void testValidId() {
		try { 
			// Test a valid ID (0) using the validateId method
			assertTrue(BloodReqValidator.validateId(5));
		} catch (ValidationException e) {
			// If an unexpected exception is caught, the test fails with an error message
			fail("An unexpected exception was thrown: " + e.getMessage());
		}
	}

	@Test
	void testInvalidId() {

		// Attempt to validate an invalid ID (2) using the validateId method
		Assertions.assertThrows(ValidationException.class, () -> BloodReqValidator.validateId(1));
		// If an exception was not thrown as expected, the test fails with an error

	}

	@Test
	void testValidBloodType() {
		try {
			// Choose a valid blood type for testing (e.g., BloodGroup.A_POSITIVE)
			BloodGroup validBloodType = BloodGroup.A_POSITIVE;

			// Validate the chosen valid blood type using the validateBloodType method
			assertTrue(BloodReqValidator.validateBloodType(validBloodType));
		} catch (ValidationException e) {
			// If an unexpected exception is caught, the test fails with an error message
			fail("An unexpected exception was thrown: " + e.getMessage());
		}
	}

	@Test
	void testValidDescription() {
		try {
			// Test a valid description using the validateDescription method
			assertTrue(BloodReqValidator.validateDescription("Valid description."));
		} catch (ValidationException e) {
			// If an unexpected exception is caught, the test fails with an error message
			fail("An unexpected exception was thrown: " + e.getMessage());
		}
	}

	@Test
	void testNullDescription() {
		try {
			// Attempt to validate a null description using the validateDescription method
			BloodReqValidator.validateDescription(null);
			// If an exception was not thrown as expected, the test fails with an error
			// message
			fail("Expected IllegalArgumentException was not thrown.");
		} catch (ValidationException e) {
			// Check if the caught exception's error message matches the expected message
			assertEquals("type the correct description", e.getMessage());
		}
	}

	@Test
	void testShortDescription() {
		try {
			// Attempt to validate a short description using the validateDescription method
			BloodReqValidator.validateDescription("No");
			// If an exception was not thrown as expected, the test fails with an error
			// message
			fail("Expected IllegalArgumentException was not thrown.");
		} catch (ValidationException e) {
			// Check if the caught exception's error message matches the expected message
			assertEquals("type the correct description", e.getMessage());
		}
	}

	@Test
	void testValidContactNo() {
		try {
			// Test a valid contact number using the validateContactNo method
			assertTrue(BloodReqValidator.validateContactNo("1234567890")); // Replace with a valid contact number
		} catch (ValidationException e) {
			// If an unexpected exception is caught, the test fails with an error message
			fail("An unexpected exception was thrown: " + e.getMessage());
		}
	}

	@Test
	void testNullContactNo() {
		try {
			// Attempt to validate a null contact number using the validateContactNo method
			BloodReqValidator.validateContactNo(null);
			// If an exception was not thrown as expected, the test fails with an error
			// message
			fail("Expected IllegalArgumentException was not thrown.");
		} catch (ValidationException e) {
			// Check if the caught exception's error message matches the expected message
			assertEquals("type the correct number", e.getMessage());
		}
	}

	@Test
	void testInvalidContactNo() {
		try {
			// Attempt to validate an invalid contact number using the validateContactNo
			// method
			BloodReqValidator.validateContactNo("abc123"); // Replace with an invalid contact number
			// If an exception was not thrown as expected, the test fails with an error
			// message
			fail("Expected IllegalArgumentException was not thrown.");
		} catch (ValidationException e) {
			// Check if the caught exception's error message matches the expected message
			assertEquals("type the correct number", e.getMessage());
		}
	}

	@Test
	void testValidReqDate() {
		try {
			// Test a valid request date using the validateReqDate method
			LocalDate validReqDate = LocalDate.now(); // Replace with a valid date
			assertTrue(BloodReqValidator.validateReqDate(validReqDate));
		} catch (ValidationException e) {
			// If an unexpected exception is caught, the test fails with an error message
			fail("An unexpected exception was thrown: " + e.getMessage());
		}
	}

	@Test
	void testNullReqDate() {
		try {
			// Attempt to validate a null request date using the validateReqDate method
			BloodReqValidator.validateReqDate(null);
			// If an exception was not thrown as expected, the test fails with an error
			// message
			fail("Expected ValidationException was not thrown.");
		} catch (ValidationException e) {
			// Check if the caught exception's error message matches the expected message
			assertEquals("type the correct reqDate", e.getMessage());
		}
	}

	@Test
	void testInvalidReqDate() {
		try {
			// Test an invalid request date using the validateReqDate method
			LocalDate invalidReqDate = LocalDate.now().plusDays(2023 - 10 - 12); // Replace with an invalid date
			assertFalse(BloodReqValidator.validateReqDate(invalidReqDate));
		} catch (ValidationException e) {
			// If an unexpected exception is caught, the test fails with an error message
			equals("An unexpected exception was thrown: " + e.getMessage());
		}
	}

}
