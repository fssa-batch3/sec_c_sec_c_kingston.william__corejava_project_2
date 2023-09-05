package com.fssa.blooddonation.model;

import com.fssa.blooddonation.enums.DonorBloodGroup;
import com.fssa.blooddonation.enums.DonorDistrict;
import com.fssa.blooddonation.enums.DonorGender;
import com.fssa.blooddonation.enums.DonorState;

public class DonorRegister {
	
	private int userId;
	private String name;
	private String MobileNo;
	private DonorBloodGroup bloodtype;
	private String address;
	private DonorState state;
	private DonorDistrict district;
	private int age;
	private String emailId;
	private DonorGender gender;
	@Override
	public String toString() {
		return "DonorRequest [userId=" + userId + ", name=" + name + ", MobileNo=" + MobileNo + ", bloodtype="
				+ bloodtype + ", address=" + address + ", state=" + state + ", district=" + district + ", age=" + age
				+ ", emailId=" + emailId + ", gender=" + gender + "]";
	}
public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public DonorBloodGroup getBloodtype() {
		return bloodtype;
	}
	public void setBloodtype(DonorBloodGroup bloodtype) {
		this.bloodtype = bloodtype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public DonorState getState() {
		return state;
	}
	public void setState(DonorState state) {
		this.state = state;
	}
	public DonorDistrict getDistrict() {
		return district;
	}
	public void setDistrict(DonorDistrict district) {
		district = district;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public DonorGender getGender() {
		return gender;
	}
	public void setGender(DonorGender gender) {
		this.gender = gender;
	}

}
