package com.alperenbozkurt.FlightRestAPI.service;

import com.alperenbozkurt.FlightRestAPI.dto.AirportCreateRequest;
import com.alperenbozkurt.FlightRestAPI.dto.AirportDTO;
import com.alperenbozkurt.FlightRestAPI.dto.FlightDto;
import com.alperenbozkurt.FlightRestAPI.entities.Airport;
import com.alperenbozkurt.FlightRestAPI.entities.Flight;
import com.alperenbozkurt.FlightRestAPI.enums.Status;
import com.alperenbozkurt.FlightRestAPI.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    private final ModelMapper modelMapper;

    public Airport createAirport(AirportCreateRequest airportCreateRequest) {
        Airport newAirport = modelMapper.map(airportCreateRequest, Airport.class);
        return airportRepository.save(newAirport);
    }

    public String deleteAirport (String id) {
        Optional<Airport> airport = airportRepository.findById(id);
        if (airport.isEmpty()) {
            return null;
        }
        airportRepository.deleteById(id);
        return "deleted airport information";
    }

    public Airport findById (String id) {
        Optional<Airport> airport = airportRepository.findById(id);
        return airport.orElse(null);
    }

    public List<AirportDTO> getAll() {
        List<Airport> airports = airportRepository.findAll();
        return airports.stream()
                .map(this::convertModelToDto)
                .toList();
    }

    public  Airport updateAirport (String id, AirportDTO airportDTO) {
        Optional<Airport> airport = airportRepository.findById(id);
        if (airport.isEmpty()) {
            return null;
        }
        Airport existingAirport = airport.get();

        existingAirport.setAirportCode(airportDTO.getAirportCode());
        existingAirport.setCity(airportDTO.getCity());
        existingAirport.setStatus(Status.UPDATED);
        existingAirport.setModifiedDateTime(LocalDateTime.now());

        return airportRepository.save(existingAirport);
    }

    private AirportDTO convertModelToDto(Airport airport) {
        return  AirportDTO.builder()
                .airportCode(airport.getAirportCode())
                .city(airport.getCity())
                .build();
    }



}
