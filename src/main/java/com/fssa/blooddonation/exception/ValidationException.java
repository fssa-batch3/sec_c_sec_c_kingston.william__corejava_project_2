package com.fssa.blooddonation.exception;

public class ValidationException extends Exception {
	private static final long serialVersionUID = 3785994329939220L;

	public ValidationException(String msg) {
		super(msg);
	}
}
