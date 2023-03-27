package com.flights.exception;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * FlighSearchExceptionHandler: Exception Handler for validation exceptions and generic exceptions.
 */
@ControllerAdvice
public class FlighSearchExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * Handle Constraint Violation Exception
	 * @param exception ConstraintViolationException
	 * @param request request
	 * @return ResponseEntity
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> handleConstraintViolationException(ConstraintViolationException exception,
			WebRequest request) {
		logger.error(exception.getMessage(), exception);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.BAD_REQUEST, exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	
	/**
	 * Generic exception handler
	 * @param ex generic Exception
	 * @param request request
	 * @return ResponseEntity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGenericException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.INTERNAL_SERVER_ERROR,
				"Internal Server Error Occured.");
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
