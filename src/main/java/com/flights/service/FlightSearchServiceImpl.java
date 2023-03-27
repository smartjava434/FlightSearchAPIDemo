package com.flights.service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flights.Constants;
import com.flights.model.Flight;
import com.flights.repository.FlightSearchRepository;

/**
 * Implementation class for Flight Search Service.
 */
@Service
public class FlightSearchServiceImpl implements FlightSearchService {
	@Autowired
	FlightSearchRepository flightSearchRepository;
	
	
	
	/**
	 * Method to retrieve and sort flights
	 * @param origin origin
	 * @param destination destination
	 * @param sortType sortType
	 */
	public List<Flight> getFlightsByOriginDestinationAndSortType(String origin, String destination, String sortType) {
		List<Flight> list = flightSearchRepository.findByOriginAndDestination(origin, destination);
		
		Comparator<Flight> comp = null;
		if (list != null && !list.isEmpty()) {
			if (Constants.SORT_TYPE_PRICE.equalsIgnoreCase(sortType)) {
				comp = Comparator.comparing(Flight::getPrice);
			}
			else if (Constants.SORT_TYPE_DURATION.equalsIgnoreCase(sortType)) {
				comp = Comparator
						.comparingDouble(e -> ChronoUnit.SECONDS.between(e.getDeparturetime(), e.getArrivaltime()));
			}	
			else if (Constants.SORT_TYPE_PRICE_AND_DURATION.equalsIgnoreCase(sortType)) {
				comp = Comparator.comparing(Flight::getPrice).thenComparing(Comparator
						.comparingDouble(e -> ChronoUnit.SECONDS.between(e.getDeparturetime(), e.getArrivaltime())));
			}else {
				comp = Comparator.comparing(Flight::getPrice);
			}	

			return list.stream().sorted(comp).collect(Collectors.toList());
		}
		else {
			return new ArrayList<>();
		}
		
	}
}
