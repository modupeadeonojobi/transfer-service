package com.example.teamapt.exception;

/**
 * @author iModupsy
 * @created 09/03/2022
 */
public class EmailExistsException extends RuntimeException {

	public EmailExistsException(final String message) {
		super(message);
	}

}
