package com.alperenbozkurt.FlightRestAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

@Data
@Builder
@NoRepositoryBean
@AllArgsConstructor
public class AirportDTO {
    private String city;
    private String airportCode;
}
