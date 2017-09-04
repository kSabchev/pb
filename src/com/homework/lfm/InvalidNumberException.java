package com.homework.lfm;

public class InvalidNumberException extends Exception {
	
	private static final long serialVersionUID = 42L;
	private String phoneNum;

	public InvalidNumberException(String number) {
		phoneNum = number;

	}

	@Override
	public String getMessage() {
		return "Phone number: " + phoneNum + " is invalid.";
	}

}