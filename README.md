
# Random IT Scenario Generator

## Overview
The **Random IT Scenario Generator** is a Spring Boot RESTful API application that generates random IT-related scenarios based on user inputs such as technology, role, and environment. It uses a predefined dataset stored in JSON format to provide diverse scenarios for various IT job functions and environments.


## Features
- Accepts user input parameters: **technology**, **role**, and **environment**.
- Returns a randomly selected scenario matching the inputs from a predefined dataset.
- Supports multiple technologies (e.g., Java, Python), roles (developer, tester), and environments (cloud, on-premise, hybrid).
- Provides clear, structured responses including challenges, incidents, and troubleshooting steps.
- Implements clean separation of concerns using Controller, Service, and Repository layers.
- Fully tested with unit tests for each layer using JUnit and Mockito.

## Technologies Used
- **Java 17** with Spring Boot Framework 3.5.4
- Spring Web for REST API development
- Jackson Databind for JSON processing
- JUnit 5 and Mockito for testing
- Maven for build and dependency management


## Future Enhancements (Optional)

- Add database support for dynamic scenarios using Spring Data JPA.
- Implement Swagger/OpenAPI documentation for API exploration.
- Add authentication/authorization for API usage.
- Build a simple frontend UI for user-friendly input and display.
