package com.flights.exception;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class FlighSearchExceptionHandlerTest {
	
	@Test
	  void testForHandlingConstraingViolationException() {
		FlighSearchExceptionHandler handler = new FlighSearchExceptionHandler();
		ResponseEntity<ErrorDetails> resp = handler.handleConstraintViolationException(new ConstraintViolationException("Sort type should be price or duration or price_duration", null),null);
		assertTrue(resp.getBody().getErrorCode().equals(HttpStatus.BAD_REQUEST));
		assertTrue(resp.getBody().getErrorMessage().equals("Sort type should be price or duration or price_duration"));
	}
	
	
	
	@Test
	  void testForHandlingGenericException() {
		FlighSearchExceptionHandler handler = new FlighSearchExceptionHandler();
		ResponseEntity<ErrorDetails> resp = handler.handleGenericException(new Exception("Generic Exception", null),null);
		assertTrue(resp.getBody().getErrorCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));
		assertTrue(resp.getBody().getErrorMessage().equals("Internal Server Error Occured."));
	}
		
}
