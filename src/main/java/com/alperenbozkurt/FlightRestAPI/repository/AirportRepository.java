package com.alperenbozkurt.FlightRestAPI.repository;

import com.alperenbozkurt.FlightRestAPI.entities.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AirportRepository extends MongoRepository<Airport, String> {
}
