package com.flights.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flights.model.Flight;
import com.flights.service.FlightSearchService;
import com.flights.validation.SortTypeConstraint;

@Validated
@RestController

/**
 * Controller class for Flight Search
 */
public class FlightSearchController {
	@Autowired
	private FlightSearchService flightSearchService;

	/**
	 * 
	 * @param origin      origin of the flight
	 * @param destination destination
	 * @param sortType    sort type: price/ duration/ both
	 * @return List of flights
	 */
	@GetMapping("/flights")
	public List<Flight> getFlightsByOriginDestinationAndSortType(@QueryParam("origin") @NotBlank String origin,
			@QueryParam("destination") @NotBlank String destination, @QueryParam("sortType") @SortTypeConstraint String sortType) {
		return flightSearchService.getFlightsByOriginDestinationAndSortType(origin, destination, sortType);
	}
	
}
