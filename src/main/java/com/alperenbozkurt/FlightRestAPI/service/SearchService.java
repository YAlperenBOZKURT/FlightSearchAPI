package com.alperenbozkurt.FlightRestAPI.service;


import com.alperenbozkurt.FlightRestAPI.entities.Airport;
import com.alperenbozkurt.FlightRestAPI.entities.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final MongoTemplate mongoTemplate;
    public List<Flight> findFligts (String departureCity, String arrivalCity, LocalDate date) {

        Airport departureAirport = mongoTemplate.findOne(
                Query.query(Criteria.where("city").is(departureCity)),
                Airport.class);

        Airport arrivalAirport = mongoTemplate.findOne(
                Query.query(Criteria.where("city").is(arrivalCity)),
                Airport.class);

        LocalDateTime startOfDay = date.atTime(0, 0, 0);
        LocalDateTime endOfDay = date.atTime(23, 59, 59);

      List<Flight> flightList =  mongoTemplate.find(
                Query.query(
                        Criteria.where("departureAirport").is(departureAirport.getAirportCode())
                                .and("arrivalAirport").is(arrivalAirport.getAirportCode())
                                .and("departureDateTime").gte(startOfDay).lte(endOfDay)
                ),
                Flight.class
        );

        return flightList;
    }

    public List<Flight> findFlightsWithDatesAndCities(
            String departureCity, String arrivalCity,
            LocalDate departureDate, LocalDate returnDate
    ) {
        Airport departureAirport = mongoTemplate.findOne(
                Query.query(Criteria.where("city").is(departureCity)),
                Airport.class);

        Airport arrivalAirport = mongoTemplate.findOne(
                Query.query(Criteria.where("city").is(arrivalCity)),
                Airport.class);

        LocalDateTime departureStartOfDay = departureDate.atTime(0, 0, 0);
        LocalDateTime departureEndOfDay = departureDate.atTime(23, 59, 59);

        LocalDateTime returnStartOfDay = returnDate.atTime(0, 0, 0);
        LocalDateTime returnEndOfDay = returnDate.atTime(23, 59, 59);

        List<Flight> departureFlights = mongoTemplate.find(
                Query.query(
                        Criteria.where("departureAirport").is(departureAirport.getAirportCode())
                                .and("arrivalAirport").is(arrivalAirport.getAirportCode())
                                .and("departureDateTime").gte(departureStartOfDay).lte(departureEndOfDay)
                ),
                Flight.class
        );

        List<Flight> returnFlights = mongoTemplate.find(
                Query.query(
                        Criteria.where("departureAirport").is(arrivalAirport.getAirportCode())
                                .and("arrivalAirport").is(departureAirport.getAirportCode())
                                .and("departureDateTime").gte(returnStartOfDay).lte(returnEndOfDay)
                ),
                Flight.class
        );

        if (returnFlights.isEmpty() || departureCity.isEmpty()) {

            return null;
        }



        List<Flight> allFlights = new ArrayList<>();
        allFlights.addAll(departureFlights);
        allFlights.addAll(returnFlights);

        return allFlights;
    }

}








