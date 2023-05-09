package com.demo.exception;

public class InvalidPersonId extends RuntimeException {

	public InvalidPersonId(String message) {
		super(message);
	}

}
