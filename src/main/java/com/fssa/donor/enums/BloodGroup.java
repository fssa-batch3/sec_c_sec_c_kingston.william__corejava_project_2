package com.fssa.donor.enums;

import com.fssa.donor.model.BloodRequest;

public enum BloodGroup {
	A_POSITIVE("A+"), A_NEGATIVE("A-"), B_POSITIVE("B+"), B_NEGATIVE("B-"), AB_POSITIVE("AB+"), AB_NEGATIVE("AB-"),
	O_POSITIVE("O+"), O_NEGATIVE("O-");

	public final String value;

	BloodGroup(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

//    // Optional: You can override the toString() method for custom display if needed
//    @Override
//    public String toString() {
//        return value;
//    }

//	public static void main(String[] args) {
//		BloodRequest req = new BloodRequest();
//		req.setDescription("A+");
//		for (BloodGroup grp : BloodGroup.values()) {
//			if (grp.value.equals(req.getBloodtype())) {
//				System.out.println("eneum and the user given valie or matched");
//			}
//		}
//	}
}
