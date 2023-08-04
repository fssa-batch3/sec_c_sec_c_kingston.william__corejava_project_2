package com.fssa.donor.model;

import java.time.LocalDate;

public class BloodRequest {
	private int id;
	private String bloodtype;
	private String description; 
	private String ContactNo;
	private LocalDate reqDate;
	private String reqVerification;
	private boolean status;
    private LocalDate closedDate;

	public BloodRequest(int id, String bloodtype, String description, String ContactNo, LocalDate reqDate,
			String reqVerification, boolean status, LocalDate modDate) {
	}

	public BloodRequest() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContactNo() {
		return ContactNo;
	}

	public void setContactNo(String ContactNo) {
		this.ContactNo = ContactNo;
	}

	public LocalDate getDate() {
		return reqDate;
	}

	public void setDate(LocalDate reqDate) {
		this.reqDate = reqDate;
	}

	public String getBloodtype() {
		return bloodtype;

	}

	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}

	public String getVerification() {
		return reqVerification;
	}

	public void setVerification(String reqVerification) {
		this.reqVerification = reqVerification;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getModDate() {
		return closedDate;
	}

	public void setModDate(LocalDate modDate) {
		this.closedDate = modDate;
	}

}
