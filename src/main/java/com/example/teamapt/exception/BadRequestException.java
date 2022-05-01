package com.example.teamapt.exception;

/**
 * @author iModupsy
 * @created 03/03/2022
 */

public class BadRequestException extends RuntimeException {

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException() {
		super("bad request");
	}

}
