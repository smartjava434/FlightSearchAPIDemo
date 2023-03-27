package com.flights.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flights.model.Flight;
import com.flights.service.FlightSearchService;

@ExtendWith(MockitoExtension.class)
class FlightSearchControllerTest {
    @InjectMocks
    FlightSearchController flightSearchController;

    @Mock
    FlightSearchService flightSearchService;

   @Test
    void testGetFlightsByOriginDestinationAndSortType() {
    	Flight flightSearch1 = new Flight("A101", "AMS","DEL",LocalDateTime.now(),LocalDateTime.now(),850.00);
    	Flight flightSearch2 = new Flight("A102", "DEL","AMS",LocalDateTime.now(),LocalDateTime.now(),850.00);
    	
    	List<Flight> flightSearchList=new ArrayList<>();
    	flightSearchList.add(flightSearch1);
    	flightSearchList.add(flightSearch2);

        when(flightSearchService.getFlightsByOriginDestinationAndSortType("AMS","DEL","price")).thenReturn(flightSearchList);
        List<Flight> result = flightSearchController.getFlightsByOriginDestinationAndSortType("AMS","DEL","price");

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getOrigin()).isEqualTo(flightSearch1.getOrigin());
        assertThat(result.get(0).getDestination()).isEqualTo(flightSearch1.getDestination());
        assertThat(result.get(0).getPrice()).isEqualTo(flightSearch1.getPrice());
        assertThat(result.get(1).getOrigin()).isEqualTo(flightSearch2.getOrigin());
        assertThat(result.get(1).getDestination()).isEqualTo(flightSearch2.getDestination());
        assertThat(result.get(1).getPrice()).isEqualTo(flightSearch2.getPrice());
}


}
