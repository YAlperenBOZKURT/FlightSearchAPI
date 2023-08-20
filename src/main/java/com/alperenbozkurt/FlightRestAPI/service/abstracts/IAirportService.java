package com.alperenbozkurt.FlightRestAPI.service.abstracts;

import com.alperenbozkurt.FlightRestAPI.dto.AirportCreateRequest;
import com.alperenbozkurt.FlightRestAPI.dto.AirportDTO;
import com.alperenbozkurt.FlightRestAPI.entities.Airport;

import java.util.List;

public interface IAirportService {

     Airport createAirport(AirportCreateRequest airportCreateRequest);

     String deleteAirport (String id);

     Airport findById (String id);

     List<AirportDTO> getAll();

     Airport updateAirport (String id, AirportDTO airportDTO);

     AirportDTO convertModelToDto(Airport airport);

}
