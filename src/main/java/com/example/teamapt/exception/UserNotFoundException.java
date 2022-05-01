package com.example.teamapt.exception;

/**
 * @author iModupsy
 * @created 30/03/2022
 */
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
	}

}
