package com.example.teamapt.exception;

/**
 * @author iModupsy
 * @created 03/03/2022
 */
public class ForbiddenException extends RuntimeException {

	public ForbiddenException(String message) {
		super(message);
	}

	public ForbiddenException() {
		super("Access forbidden");
	}

}
