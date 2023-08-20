package com.alperenbozkurt.FlightRestAPI;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class FlightRestApiApplication {



	public static void main(String[] args) {
		SpringApplication.run(FlightRestApiApplication.class, args);
	}


}
