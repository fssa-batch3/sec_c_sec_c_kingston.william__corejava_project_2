package com.fssa.blooddonation.model;

import com.fssa.blooddonation.enums.BloodGroup;
import com.fssa.blooddonation.enums.Gender;

public class User {
	private String name;
	private String phoneNo; 
	private String email;
	private Gender gender;
	private BloodGroup bloodGroup;
	private String passWord;

	public User(String name, String phoneNo, String email, Gender gender, BloodGroup bloodGroup, String passWord) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.passWord = passWord;
	}
	public User() {
	
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", phoneNo=" + phoneNo + ", email=" + email + ", gender=" + gender
				+ ", bloodGroup=" + bloodGroup + ", passWord=" + passWord + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
