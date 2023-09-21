package com.fssa.blooddonation.enums;

import java.util.HashMap;

public enum RequestStatus {
	// Enum constants with their corresponding values
	CLOSED("Closed"), OPEN("Open");

	// Property to store the value of each enum constant
	public final String value;

	// Constructor to initialize the enum constants with values
	RequestStatus(String value) {
		this.value = value;
	}

	// Getter method to retrieve the value of the enum constant
	public String getValue() {
		return value;
	}

	// Static method to map a string value to the corresponding enum constant
	public static RequestStatus valueToEnumMapping(String value) {
		// Create a mapping of values to enum constants using a HashMap
		HashMap<String, RequestStatus> valueToEnumMapping = new HashMap<String, RequestStatus>();

		// Iterate through all RequestStatus enum constants and populate the mapping
		for (RequestStatus status : RequestStatus.values()) {
			valueToEnumMapping.put(status.getValue(), status);
		}

		// Return the enum constant corresponding to the provided value
		return valueToEnumMapping.get(value);
	}
}
