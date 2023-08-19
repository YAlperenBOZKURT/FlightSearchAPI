package com.alperenbozkurt.FlightRestAPI.repository;

import com.alperenbozkurt.FlightRestAPI.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
}
