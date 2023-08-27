package com.alperenbozkurt.FlightRestAPI.controller;

import com.alperenbozkurt.FlightRestAPI.dto.AirportCreateRequest;
import com.alperenbozkurt.FlightRestAPI.dto.AirportDTO;
import com.alperenbozkurt.FlightRestAPI.entities.Airport;
import com.alperenbozkurt.FlightRestAPI.service.abstracts.IAirportService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
@RequiredArgsConstructor
public class AirportController {

    private final IAirportService airportService;


    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody AirportCreateRequest airportCreateRequest) {
        Airport newAirport = airportService.createAirport(airportCreateRequest);
        if (newAirport == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(newAirport);
    }


    @GetMapping
    public ResponseEntity<List<AirportDTO>> getAll() {
        List<AirportDTO> airportDTOList = airportService.getAll();
        return ResponseEntity.ok(airportDTOList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable String id) {
        try {
            airportService.deleteAirport(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable String id, @RequestBody AirportDTO airportDTO) {
        Airport uptatedAirport = airportService.updateAirport(id, airportDTO);
        if (uptatedAirport != null) {
            return  ResponseEntity.ok(uptatedAirport);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Airport> getAirportById(@PathVariable String id) {
        Airport airport = airportService.findById(id);
        if (airport == null) {
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(airportService.findById(id));
    }
}
