package com.alperenbozkurt.FlightRestAPI.service.abstracts;

import com.alperenbozkurt.FlightRestAPI.entities.Flight;

import java.time.LocalDate;
import java.util.List;

public interface ISearchService {

    List<Flight> findFligts(String departureCity, String arrivalCity, LocalDate date);

    List<Flight> findFlightsWithDatesAndCities(
            String departureCity, String arrivalCity,
            LocalDate departureDate, LocalDate returnDate
    );


}
