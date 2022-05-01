package com.example.teamapt.exception;

/**
 * @author iModupsy
 * @created 03/03/2022
 */
public class NotFoundException extends RuntimeException {

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException() {
		super("not found");
	}

}
