package com.alperenbozkurt.FlightRestAPI.entities;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "airports")
public class Airport {

    @Id
    private String id = UUID.randomUUID().toString();

    @NotBlank(message = "City cannot be empty")
    private String city;

    @NotBlank(message = "Airport code cannot be empty")
    private String airportCode;
}
