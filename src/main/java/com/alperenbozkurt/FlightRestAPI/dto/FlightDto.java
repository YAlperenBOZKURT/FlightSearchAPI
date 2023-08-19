package com.alperenbozkurt.FlightRestAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;

@Data
@Builder
@NoRepositoryBean
@AllArgsConstructor
public class FlightDto {

    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private Double price;

}
