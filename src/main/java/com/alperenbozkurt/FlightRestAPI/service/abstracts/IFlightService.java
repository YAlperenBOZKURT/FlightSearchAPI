package com.alperenbozkurt.FlightRestAPI.service.abstracts;

import com.alperenbozkurt.FlightRestAPI.dto.FlightCreateRequest;
import com.alperenbozkurt.FlightRestAPI.dto.FlightDto;
import com.alperenbozkurt.FlightRestAPI.entities.Flight;

import java.util.List;

public interface IFlightService {

    Flight createFlight(FlightCreateRequest flightCreateRequest);
    List<FlightDto> getAllFlights();
    Flight findFlightById(String id);
    void deleteFlight(String id);
    Flight updateFlight(String id, FlightDto flightDTO);
    FlightDto convertModelToDto(Flight flight);
    void saveFlightsFromMockData(String mockData);
    List<Flight> parseMockDataAndCreateFlightEntities(String mockData);









}
