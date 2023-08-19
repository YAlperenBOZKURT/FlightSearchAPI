package com.alperenbozkurt.FlightRestAPI.repository;

import com.alperenbozkurt.FlightRestAPI.entities.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {

    List<Flight> findByDepartureAirportAndDepartureDateTimeBetweenAndArrivalAirport(String departureAirport, LocalDate firstDate, String arrivalAirport);

    List<Flight> findByDepartureAirportAndDepartureDateTimeBetweenAndArrivalAirport(String departureAirport, LocalDate departureDate, String arrivalAirport, LocalDate returnDate);

}
