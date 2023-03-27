package com.flights.service;

import java.util.List;

import com.flights.model.Flight;

/**
 * Interface class for Flight Search 
 */
public interface FlightSearchService {
	/**
	 * 
	 * @param origin origin
	 * @param destination destination
	 * @param sortType sortType
	 * @return List<Flight>
	 */
	public List<Flight> getFlightsByOriginDestinationAndSortType(String origin, String destination, String sortType);
}
