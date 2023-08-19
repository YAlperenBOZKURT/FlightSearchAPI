package com.alperenbozkurt.FlightRestAPI.entities;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "flights")
public class Flight extends BaseEntity {

    @NotBlank(message = "Departure airport cannot be empty")
    private String departureAirport;

    @NotBlank(message = "Arrival airport cannot be empty")
    private String arrivalAirport;

    @NotNull(message = "Departure date/time cannot be empty")
    private LocalDateTime departureDateTime;

    @NotNull(message = "Arrival date/time cannot be empty")
    private LocalDateTime arrivalDateTime;

    @NotNull(message = "Price cannot be empty")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private Double price;
}
