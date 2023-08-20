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
public class AirportCreateRequest {

    private String city;
    private String airportCode;
    private Status status;
    private LocalDateTime createdDateTime;
    private String createdBy;
    private LocalDateTime modifiedDateTime;
    private String modifiedBy;
}
