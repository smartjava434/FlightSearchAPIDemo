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
	Flight flight1 = new Flight();
	Flight flight2 = new Flight();

	@BeforeEach
	public void setup() {
		flight1 = new Flight("A102", "AMS", "DEL", LocalDateTime.of(2023, 3, 26, 1, 0, 0),LocalDateTime.of(2023, 3, 27, 23, 0, 0), 850.00);
		flight2 = new Flight("A101", "AMS", "DEL", LocalDateTime.of(2023, 3, 26, 1, 0, 0),LocalDateTime.of(2023, 3, 27, 12, 0, 0), 800.00);
		flightSearchList.add(flight1);
		flightSearchList.add(flight2);
	}

	@Test
	void testGetFlightsByOriginDestinationAndSortTypeAsPrice() {
		Mockito.when(flightSearchRepository.findByOriginAndDestination("AMS", "DEL")).thenReturn(flightSearchList);
		assertThat(flightSearchServiceImpl.getFlightsByOriginDestinationAndSortType("AMS", "DEL", "price").get(0)).isEqualTo(flight2);
		assertThat(flightSearchServiceImpl.getFlightsByOriginDestinationAndSortType("AMS", "DEL", "price").get(1)).isEqualTo(flight1);
	}

	@Test
	void testGetFlightsByOriginDestinationAndSortTypeAsDuration() {
		Mockito.when(flightSearchRepository.findByOriginAndDestination("AMS", "DEL")).thenReturn(flightSearchList);
		assertThat(flightSearchServiceImpl.getFlightsByOriginDestinationAndSortType("AMS", "DEL", "duration").get(0)).isEqualTo(flight2);
		assertThat(flightSearchServiceImpl.getFlightsByOriginDestinationAndSortType("AMS", "DEL", "duration").get(1)).isEqualTo(flight1);
	}

	@Test
	void testGetFlightsByOriginDestinationAndSortTypeAsPrice_Duration() {
		Flight flight3 = new Flight("A103", "AMS", "DEL", LocalDateTime.of(2023, 3, 26, 1, 0, 0),LocalDateTime.of(2023, 3, 27, 12, 0, 0), 850.00);
		flightSearchList.add(flight3);
		Mockito.when(flightSearchRepository.findByOriginAndDestination("AMS", "DEL")).thenReturn(flightSearchList);
		assertThat(flightSearchServiceImpl.getFlightsByOriginDestinationAndSortType("AMS", "DEL", "price_duration").get(0)).isEqualTo(flight2);
		assertThat(flightSearchServiceImpl.getFlightsByOriginDestinationAndSortType("AMS", "DEL", "price_duration").get(1)).isEqualTo(flight3);
		assertThat(flightSearchServiceImpl.getFlightsByOriginDestinationAndSortType("AMS", "DEL", "price_duration").get(2)).isEqualTo(flight1);
	}

}