package com.fssa.blooddonation.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public enum DonorDistrict {
    CHENNAI("Chennai"),
    COIMBATORE("Coimbatore"),
    MADURAI("Madurai"),
    SALEM("Salem"),
    TRICHY("Tiruchirapalli"),
    ERODE("Erode"),
    VELLORE("Vellore"),
    THANJAVUR("Thanjavur"),
    TIRUNELVELI("Tirunelveli"),
    TIRUPPUR("Tiruppur"),
    TUTICORIN("Thoothukudi"),
    KANCHIPURAM("Kanchipuram"),
    THIRUVALLUR("Thiruvallur"),
    NAMAKKAL("Namakkal"),
    VIRUDHUNAGAR("Virudhunagar"),
    DHARMAPURI("Dharmapuri"),
    CUDDALORE("Cuddalore"),
    KARUR("Karur"),
    RAMANATHAPURAM("Ramanathapuram"),
    SIVAGANGA("Sivaganga"),
    PERAMBALUR("Perambalur"),
    NILGIRIS("The Nilgiris"),
    ARIYALUR("Ariyalur");

	public final String value;

	// Constructor to initialize the enum constants with values
	DonorDistrict(String value) {
		this.value = value;
	}

	// Getter method to retrieve the value of the enum constant
	public String getValue() {
		return value;
	};

	// Static method to map a string value to the corresponding enum constant
	public static DonorDistrict valueToEnumMapping(String value) {
		// Create a mapping of values to enum constants using a HashMap
		HashMap<String, DonorDistrict> valueToEnumMapping = new HashMap<String, DonorDistrict>();

		// Iterate through all BloodGroup enum constants and populate the mapping
		for (DonorDistrict bloodGroup : DonorDistrict.values()) {
			valueToEnumMapping.put(bloodGroup.getValue(), bloodGroup);
		}

		// Return the enum constant corresponding to the provided value
		return valueToEnumMapping.get(value);

	}
}
