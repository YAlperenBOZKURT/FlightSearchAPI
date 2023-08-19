package com.alperenbozkurt.FlightRestAPI.dto;

import com.alperenbozkurt.FlightRestAPI.enums.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;

@Data
@Builder
@NoRepositoryBean
@AllArgsConstructor
public class FlightCreateRequest {

    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private Double price;
    private Status status;
    private LocalDateTime createdDateTime;
    private String createdBy;
    private LocalDateTime modifiedDateTime;
    private String modifiedBy;
}
