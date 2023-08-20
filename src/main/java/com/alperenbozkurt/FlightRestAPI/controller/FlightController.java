package com.alperenbozkurt.FlightRestAPI.controller;

import com.alperenbozkurt.FlightRestAPI.dto.FlightCreateRequest;
import com.alperenbozkurt.FlightRestAPI.dto.FlightDto;
import com.alperenbozkurt.FlightRestAPI.entities.Flight;
import com.alperenbozkurt.FlightRestAPI.service.concrete.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody FlightCreateRequest flightCreateRequest) {
        Flight newFlight = flightService.createFlight(flightCreateRequest);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<FlightDto>> getAll() {
      List<FlightDto> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> findById(@PathVariable String id) {
        Flight flight = flightService.findFlightById(id);
        if (flight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else  {
            return new ResponseEntity<>(flight, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable String id) {
        try {
            flightService.deleteFlight(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Flight>  updateFlight(@PathVariable String id, FlightDto flightDto) {
        Flight uptatedFlight = flightService.updateFlight(id, flightDto);
        if (uptatedFlight != null) {
            return  ResponseEntity.ok(uptatedFlight);
        }
        return ResponseEntity.notFound().build();
    }

}
