package com.alperenbozkurt.FlightRestAPI;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
public class FlightRestApiApplication {



	public static void main(String[] args) {
		SpringApplication.run(FlightRestApiApplication.class, args);
	}


}
