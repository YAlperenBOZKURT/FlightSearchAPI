package com.alperenbozkurt.FlightRestAPI.scheduler;

import com.alperenbozkurt.FlightRestAPI.service.FlightService;
import com.alperenbozkurt.FlightRestAPI.util.MockDataGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FlightDataScheduler {

    private final FlightService flightService;

    @Scheduled(cron = "0 0 1 * * ?") // Run at 1:00 AM every day
    public void generateAndSaveMockFlights() {
        String mockApiResponse = MockDataGenerator.generateMockFlights();
        flightService.saveFlightsFromMockData(mockApiResponse);
        System.out.println("Mock flights generated and saved to the database.");
    }

}
