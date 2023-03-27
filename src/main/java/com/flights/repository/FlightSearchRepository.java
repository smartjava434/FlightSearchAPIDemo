package com.flights.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flights.model.Flight;

/**
 *  FlightSearchRepository for finding/retrieving flights.
 */
@Repository
public interface FlightSearchRepository extends CrudRepository<Flight, String> {
	public List<Flight> findByOriginAndDestination(String origin, String destination);
}
