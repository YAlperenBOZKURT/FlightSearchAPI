package com.alperenbozkurt.FlightRestAPI.service;

import com.alperenbozkurt.FlightRestAPI.dto.FlightCreateRequest;
import com.alperenbozkurt.FlightRestAPI.dto.FlightDto;
import com.alperenbozkurt.FlightRestAPI.entities.Flight;
import com.alperenbozkurt.FlightRestAPI.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    private final ModelMapper modelMapper;

    public Flight createFlight(FlightCreateRequest flightCreateRequest) {
        Flight newFlight = modelMapper.map(flightCreateRequest, Flight.class);
        return flightRepository.save(newFlight);
    }

    public List<FlightDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        List<FlightDto> flightDtos = flights.stream()
                .map(this::convertModelToDto)
                .toList();
        return flightDtos;
    }

    public Flight findFlightById(String id) {
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isPresent()) {
            return flight.get();
        }
        return null;
    }

    public void deleteFlight(String id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> findOneWayFlights(String departureAirport, LocalDate departureDate, String arrivalAirport) {
        return flightRepository.findByDepartureAirportAndDepartureDateTimeBetweenAndArrivalAirport(
                departureAirport, departureDate, arrivalAirport
        );
    }

    public List<Flight> findComplexFlights(String departureAirport, LocalDate departureDate, String arrivalAirport, LocalDate returnDate) {
        return flightRepository.findByDepartureAirportAndDepartureDateTimeBetweenAndArrivalAirport(
                departureAirport, departureDate, arrivalAirport, returnDate
        );
    }

    public Flight updateFlight(String id, FlightDto flightDTO) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if (optionalFlight.isPresent()) {
            Flight existingFlight = optionalFlight.get();

            existingFlight.setArrivalAirport(flightDTO.getArrivalAirport());
            existingFlight.setPrice(flightDTO.getPrice());
            existingFlight.setArrivalDateTime(flightDTO.getArrivalDateTime());
            existingFlight.setDepartureAirport(flightDTO.getDepartureAirport());
            existingFlight.setDepartureDateTime(flightDTO.getDepartureDateTime());

            return existingFlight;
        }
        return null;
    }


    private FlightDto convertModelToDto(Flight flight) {
        return  FlightDto.builder()
                .price(flight.getPrice())
                .arrivalAirport(flight.getArrivalAirport())
                .arrivalDateTime(flight.getArrivalDateTime())
                .departureAirport(flight.getDepartureAirport())
                .departureDateTime(flight.getDepartureDateTime())
                .build();
    }


}
