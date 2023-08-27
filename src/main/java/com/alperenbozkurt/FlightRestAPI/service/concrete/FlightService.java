package com.alperenbozkurt.FlightRestAPI.service.concrete;

import com.alperenbozkurt.FlightRestAPI.dto.FlightCreateRequest;
import com.alperenbozkurt.FlightRestAPI.dto.FlightDto;
import com.alperenbozkurt.FlightRestAPI.entities.Airport;
import com.alperenbozkurt.FlightRestAPI.entities.Flight;
import com.alperenbozkurt.FlightRestAPI.enums.Status;
import com.alperenbozkurt.FlightRestAPI.repository.FlightRepository;
import com.alperenbozkurt.FlightRestAPI.service.abstracts.IFlightService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService implements IFlightService {

    private final FlightRepository flightRepository;

    private final ModelMapper modelMapper;


    // Classic CRUD operations.
    @Override
    public Flight createFlight(FlightCreateRequest flightCreateRequest) {
        Flight newFlight = modelMapper.map(flightCreateRequest, Flight.class);
        return flightRepository.save(newFlight);
    }

    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream()
                .map(this::convertModelToDto)
                .toList();
    }

    @Override
    public Flight findFlightById(String id) {
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isPresent()) {
            return flight.get();
        }
        return null;
    }

    @Override
    public void deleteFlight(String id) {
        flightRepository.deleteById(id);
    }


    @Override
    public Flight updateFlight(String id, FlightDto flightDTO) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);

        System.out.println(flightDTO.getArrivalDateTime());
        System.out.println(flightDTO.getDepartureDateTime());
        if (optionalFlight.isPresent()) {
            Flight existingFlight = optionalFlight.get();

            existingFlight.setArrivalAirport(flightDTO.getArrivalAirport());
            existingFlight.setPrice(flightDTO.getPrice());
            existingFlight.setArrivalDateTime(flightDTO.getArrivalDateTime());
            existingFlight.setDepartureAirport(flightDTO.getDepartureAirport());
            existingFlight.setDepartureDateTime(flightDTO.getDepartureDateTime());
            existingFlight.setStatus(Status.UPDATED);
            existingFlight.setModifiedDateTime(LocalDateTime.now());



            return flightRepository.save(existingFlight);
        }
        return null;
    }

    @Override
    public FlightDto convertModelToDto(Flight flight) {
        return  FlightDto.builder()
                .price(flight.getPrice())
                .arrivalAirport(flight.getArrivalAirport())
                .arrivalDateTime(flight.getArrivalDateTime())
                .departureAirport(flight.getDepartureAirport())
                .departureDateTime(flight.getDepartureDateTime())
                .build();
    }

    @Override
    public void saveFlightsFromMockData(String mockData) {
        List<Flight> flights = parseMockDataAndCreateFlightEntities(mockData);
        flightRepository.saveAll(flights);
    }

    // Parse mock data and create flight entities.
    @Override
    public List<Flight> parseMockDataAndCreateFlightEntities(String mockData) {
        List<Flight> flights = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(mockData);
            JsonNode flightsNode = rootNode.get("flights");

            for (JsonNode flightNode : flightsNode) {
                Flight flight = new Flight();
                flight.setDepartureAirport(flightNode.get("departureAirport").asText());
                flight.setArrivalAirport(flightNode.get("arrivalAirport").asText());
                flight.setDepartureDateTime(LocalDateTime.parse(flightNode.get("departureDateTime").asText()));
                flight.setArrivalDateTime(LocalDateTime.parse(flightNode.get("arrivalDateTime").asText()));
                flight.setPrice(flightNode.get("price").asDouble());
                flight.setStatus(Status.INSERTED);
                flight.setCreatedDateTime(LocalDateTime.parse(flightNode.get("createdDateTime").asText()));
                flight.setCreatedBy(flightNode.get("createdBy").asText());

                flights.add(flight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flights;
    }
}
