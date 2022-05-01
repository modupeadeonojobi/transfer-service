package com.example.teamapt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author iModupsy
 * @created 10/03/2022
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ApiError> handleBadRequestException(BadRequestException e) {
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		return new ResponseEntity<>(error, error.getHttpStatus());
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiError> handleNotFoundException(NotFoundException e) {
		ApiError error = new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		return new ResponseEntity<>(error, error.getHttpStatus());
	}

	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<ApiError> handleForbiddenException(ForbiddenException e) {
		ApiError error = new ApiError(HttpStatus.FORBIDDEN, e.getLocalizedMessage());
		return new ResponseEntity<>(error, error.getHttpStatus());
	}

	@ExceptionHandler(EmailExistsException.class)
	public ResponseEntity<ApiError> handleEmailExistsException(EmailExistsException e) {
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		return new ResponseEntity<>(error, error.getHttpStatus());
	}

	@ExceptionHandler(RoleExistsException.class)
	public ResponseEntity<ApiError> handleRoleExistsException(RoleExistsException e) {
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		return new ResponseEntity<>(error, error.getHttpStatus());
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiError> handleUserNotFoundException(UserNotFoundException e) {
		ApiError error = new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		return new ResponseEntity<>(error, error.getHttpStatus());
	}

}
