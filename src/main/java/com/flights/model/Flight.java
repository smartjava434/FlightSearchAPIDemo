package com.flights.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class representing a Flight 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
	@Id
	@Column
	private String number;
	@Column
	private String origin;
	@Column
	private String destination;
	@Column
	private LocalDateTime departuretime;
	@Column
	private LocalDateTime arrivaltime;
	@Column
	private Double price;

}
