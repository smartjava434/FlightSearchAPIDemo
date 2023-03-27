package com.flights.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flights.model.Flight;
import com.flights.repository.FlightSearchRepository;

@ExtendWith(MockitoExtension.class)
class FlightSearchServiceImplTest {
	@Mock
	FlightSearchRepository flightSearchRepository;
	@InjectMocks
	FlightSearchServiceImpl flightSearchServiceImpl;

	List<Flight> flightSearchList = new ArrayList<>();

	@BeforeEach
	public void setup() {
		Flight flightSearch1 = new Flight("A101", "AMS", "DEL", LocalDateTime.now(), LocalDateTime.now(), 800.00);
		Flight flightSearch2 = new Flight("A102", "AMS", "DEL", LocalDateTime.now(), LocalDateTime.now(), 850.00);
		flightSearchList.add(flightSearch1);
		flightSearchList.add(flightSearch2);
		Mockito.when(flightSearchRepository.findByOriginAndDestination("AMS", "DEL")).thenReturn(flightSearchList);
	}

	@Test
	void testGetFlightsByOriginDestinationAndSortTypeAsPrice() {
		assertThat(flightSearchServiceImpl.getFlightsByOriginDestinationAndSortType("AMS", "DEL", "price"))
				.isEqualTo(flightSearchList);
	}

	@Test
	void testGetFlightsByOriginDestinationAndSortTypeAsDuration() {
		assertThat(flightSearchServiceImpl.getFlightsByOriginDestinationAndSortType("AMS", "DEL", "duration"))
				.isEqualTo(flightSearchList);
	}

	@Test
	void testGetFlightsByOriginDestinationAndSortTypeAsPrice_Duration() {
		assertThat(flightSearchServiceImpl.getFlightsByOriginDestinationAndSortType("AMS", "DEL", "price_duration"))
				.isEqualTo(flightSearchList);
	}

}
