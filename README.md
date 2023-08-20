
# Flight Search API (Backend Developer)

This project focuses on building the backend API for a flight search application. This project has been authored by Yusuf Alperen Bozkurt. My contact details can be found in my profile.

## Table of Contents

- [Description](#description)
- [Productions](#productions)
- - [Data Modeling](#data-modeling)
- - [CRUD Operations](#crud-operations)
- - [Search API](#search-api)
- - [Authentication](#authentication)
- - [Scheduled Jobs](#scheduled-jobs)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Repository](#repository)
- [Documentation](#documentation)

## Description

This project has been meticulously crafted to address the requirements presented in the Backend Flight Service API case by Amadeus. The core functionality encompasses conventional CRUD operations applied to models such as Flight and Airport. The implementation also encompasses Jwt token-based authentication for secure access control. Furthermore, a tailored Search API has been developed to optimize data retrieval. In addition, the project features the generation of mock data and the integration of Scheduled Jobs to periodically persist data.
## Productions

### Data Modeling

I have utilized MongoDB, a NoSQL database, to manage data storage and retrieval within the application. The data is seamlessly stored within a MongoDB Atlas server, a robust cloud-based database service. This strategic choice ensures efficient and secure data management, contributing to the overall scalability and reliability of the system.
#### Flights
- ID
- Departure Airport
- Arrival Airport
- Departure Date/Time
- Return Date/Time
- Price

#### Airports
- ID
- City

### CRUD Operations

The application should implement CRUD (Create, Read, Update, Delete) operations for flights and airports. This ensures efficient management and manipulation of data.

### Search API

I have developed an API that facilitates the listing of flights for users based on their departure and arrival cities, along with the specified travel date. If the user provides a return date as well, the API additionally presents flights from the departure city to the arrival city on the given return date. This functionality ensures that users can conveniently access flight options for both one-way and round-trip journeys, enhancing their travel planning experience.

### Authentication

I have leveraged a Jwt token-based authentication system for the purpose of ensuring robust user authentication. In alignment with this approach, I meticulously configured the system's security parameters to adhere to industry best practices. Furthermore, I seamlessly integrated crucial functionalities including user login and registration processes, enhancing the overall security and user experience of the system.
### Scheduled Jobs

As part of the project, I have developed a Scheduled Job that runs every day at 01:00 AM to facilitate the daily generation of synthetic data and its systematic recording into the system. I achieve this by employing a script called MockDataGenerator for producing artificial data. Additionally, utilizing a scheduler named FlightDataScheduler, I save the data into the database every day at 01:00 AM.

## Technologies

- Java (Spring Boot)
- Database MongoDb Atlas
- Jwt Token Base Authentication
- Swagger (API Documentation)
- Git (Version Control)

## Getting Started

1. Clone the project repository.
2. Navigate to the project folder.
3. Run the following command to start the application:

   ```
   mvn spring-boot:run
   ```


## Repository

The project source code is available on [GitHub](https://github.com/YAlperenBOZKURT/FlightSearchAPI).

## Documentation

Explore the API endpoints and usage details in the [Swagger Documentation](http://localhost:8080/swagger-ui.html).

---

Feel free to modify and tailor this template according to your project's specifics.
