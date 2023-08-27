package com.alperenbozkurt.FlightRestAPI.controller;


import com.alperenbozkurt.FlightRestAPI.entities.Flight;
import com.alperenbozkurt.FlightRestAPI.service.abstracts.ISearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchFlightController {

    private  final ISearchService searchService;


    @GetMapping("/findFlights")
    public List<Flight> findFlights(
            @RequestParam String departureCity,
            @RequestParam String arrivalCity,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate
    ) {
        if (returnDate != null) {
            // If the user has provided a return date, execute the complex query.
            return searchService.findFlightsWithDatesAndCities(departureCity, arrivalCity, departureDate, returnDate);
        } else {
            // If the user hasn't provided a return date, execute the regular query.
            return searchService.findFligts(departureCity, arrivalCity, departureDate);
        }
    }


}
