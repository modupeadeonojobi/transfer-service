package com.example.teamapt.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author iModupsy
 * @created 10/03/2022
 */
@Data
@RequiredArgsConstructor
public class ApiError {

	private final HttpStatus httpStatus;

	private final String message;

}
