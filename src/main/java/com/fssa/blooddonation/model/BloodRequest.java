package com.fssa.blooddonation.model;

import java.time.LocalDate;

import com.fssa.blooddonation.enums.BloodGroup;
import com.fssa.blooddonation.enums.RequestStatus;

public class BloodRequest {
	private int id;
	private String name;
	private int quantity;
	private BloodGroup bloodtype;
	private String description;
	private String ContactNo;
	private LocalDate reqDate;
	private boolean reqVerification;
	private RequestStatus status;
	private int userId;

 

	

	public BloodRequest(String name, int quantity, BloodGroup bloodtype, String description, String contactNo,
			LocalDate reqDate, boolean reqVerification, RequestStatus status,  LocalDate closedDate ,int userId) {
		super();
		
		this.name = name;
		this.quantity = quantity;
		this.bloodtype = bloodtype;
		this.description = description;
		ContactNo = contactNo;
		this.reqDate = reqDate;
		this.reqVerification = reqVerification;
		this.status = status;
		this.closedDate = closedDate;
		this.userId=userId;
	}

	private LocalDate closedDate;

	public BloodRequest() {
		// Default constructor, possibly auto-generated by the IDE
		// It does nothing in particular, as it's empty
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Getter and setter methods for the 'id' attribute
	public int getId() {
		return id; // Returns the 'id' attribute
	}

	public void setId(int id) {
		this.id = id; // Sets the 'id' attribute with the provided value
	}

	// Getter and setter methods for the 'description' attribute
	public String getDescription() {
		return description; // Returns the 'description' attribute
	}

	public void setDescription(String description) {
		this.description = description; // Sets the 'description' attribute with the provided value
	}

	// Getter and setter methods for the 'ContactNo' attribute
	public String getContactNo() {
		return ContactNo; // Returns the 'ContactNo' attribute
	}

	public void setContactNo(String ContactNo) {
		this.ContactNo = ContactNo; // Sets the 'ContactNo' attribute with the provided value
	}

	// Getter and setter methods for the 'reqDate' attribute
	public LocalDate getReqDate() {
		return reqDate; // Returns the 'reqDate' attribute
	}

	public void setReqDate(LocalDate reqDate) {
		this.reqDate = reqDate; // Sets the 'reqDate' attribute with the provided value
	}

	// Getter and setter methods for the 'bloodtype' attribute
	public BloodGroup getBloodtype() {
		return bloodtype; // Returns the 'bloodtype' attribute
	}

	public void setBloodtype(BloodGroup bloodtype) {
		this.bloodtype = bloodtype; // Sets the 'bloodtype' attribute with the provided value
	}

	// Getter and setter methods for the 'reqVerification' attribute
	public boolean getVerification() {
		return reqVerification; // Returns the 'reqVerification' attribute
	}

	public void setVerification(boolean reqVerification) {
		this.reqVerification = reqVerification; // Sets the 'reqVerification' attribute with the provided value
	}

	// Getter and setter methods for the 'status' attribute
	public RequestStatus getStatus() {
		return status; // Returns the 'status' attribute
	}

	public void setStatus(RequestStatus status) {
		this.status = status; // Sets the 'status' attribute with the provided value
	}

	

	// Getter and setter methods for the 'closedDate' attribute
	public LocalDate getCloseDate() {
		return closedDate; // Returns the 'closedDate' attribute
	}

	public void setCloseDate(LocalDate closedDate) {
		this.closedDate = closedDate; // Sets the 'closedDate' attribute with the provided value
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BloodRequest [name=" + name + ", quantity=" + quantity + ", bloodtype=" + bloodtype + ", description="
				+ description + ", ContactNo=" + ContactNo + ", reqDate=" + reqDate + ", reqVerification="
				+ reqVerification + ", status=" + status + ", userId=" + userId + ", closedDate=" + closedDate + "]";
	}

}
