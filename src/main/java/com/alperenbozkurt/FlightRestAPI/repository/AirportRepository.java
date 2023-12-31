package com.alperenbozkurt.FlightRestAPI.repository;

import com.alperenbozkurt.FlightRestAPI.entities.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends BaseRepository<Airport, String> {
}
