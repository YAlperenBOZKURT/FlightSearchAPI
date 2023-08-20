package com.alperenbozkurt.FlightRestAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public  interface BaseRepository<T, id> extends MongoRepository<T, id> {
}
