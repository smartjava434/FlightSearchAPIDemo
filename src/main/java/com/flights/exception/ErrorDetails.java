package com.flights.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * POJO for error details 
 */
@Data
@AllArgsConstructor
public class ErrorDetails {
	private Date errorDate;
	private HttpStatus errorCode;
	private String errorMessage;
	
	public ErrorDetails(Date date, String errorMessage) {
		this.errorDate = date;
		this.errorMessage = errorMessage;
	}
	
}
