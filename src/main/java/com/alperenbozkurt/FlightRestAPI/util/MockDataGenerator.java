package com.alperenbozkurt.FlightRestAPI.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MockDataGenerator {

    public static String  generateMockFlights() {
        // Random airplane codes
        String[] airportCodes = {"ADA", "ESB", "AYT", "GZP", "EDO", "YEI", "CKZ", "DNZ", "DIY", "EZS"};

        // Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        // Create a JSON structure with random data
        Random random = new Random();
        ObjectNode root = JsonNodeFactory.instance.objectNode();
        ArrayNode flightsArrayNode = JsonNodeFactory.instance.arrayNode();

        for (int i = 0; i < 10; i++) {
            ObjectNode flightNode = JsonNodeFactory.instance.objectNode();

            // Randomly select departure and arrival airport codes
            String departureAirport = airportCodes[random.nextInt(airportCodes.length)];
            String arrivalAirport = departureAirport;
            while (arrivalAirport.equals(departureAirport)) {
                arrivalAirport = airportCodes[random.nextInt(airportCodes.length)];
            }
            flightNode.put("departureAirport", departureAirport);
            flightNode.put("arrivalAirport", arrivalAirport);

            // Generate a random departure date 1 week from now
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime departureDateTime = now.plusDays(7).withHour(random.nextInt(24)).withMinute(random.nextInt(60));
            LocalDateTime arrivalDateTime = departureDateTime.plusHours(random.nextInt(24)).plusMinutes(random.nextInt(60));
            flightNode.put("departureDateTime", departureDateTime.format(formatter));
            flightNode.put("arrivalDateTime", arrivalDateTime.format(formatter));

            // Generate a random price between 100 and 500
            int price = random.nextInt(401) + 100;
            flightNode.put("price", price);

            flightNode.put("status", "Inserted");
            flightNode.put("createdDateTime", LocalDateTime.now().format(formatter));
            flightNode.put("createdBy", "Robot");

            flightsArrayNode.add(flightNode);
        }

        root.set("flights", flightsArrayNode);

        String mockApiResponse = "";
        try {
            mockApiResponse = objectMapper.writeValueAsString(root);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mockApiResponse;
    }
}
