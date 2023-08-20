package com.alperenbozkurt.FlightRestAPI.config;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@io.swagger.v3.oas.annotations.OpenAPIDefinition
        (
                info = @Info(
                        contact =  @Contact(
                                name = "Yusuf Alperen Bozkurt",
                                email = "yalperenbozkurt@gmail.com",
                                url = "https://www.linkedin.com/in/yalperenbozkurt/"

                        ),
                        description = "Case Study: Flight Search API - Yusuf Alperen BOZKURT ",
                        title = "Flight Service API ",
                        version = "1.0",
                        termsOfService = "Terms of Service"
                )

        )
public class OpenAPIDefinition {
}
