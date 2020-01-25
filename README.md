# Tokigames-Challenge

Attempt at the TokiGames coding challenge

## Getting Started

This is a spring-boot app running webflux.

### Prerequisites

We will need Maven and Java to run this project

```
# Install maven
https://maven.apache.org/install.html

# Install Java 8 or higher
https://java.com/en/download/help/download_options.xml
```

### Installing

```bash
mvn install
```

## Running the tests

```bash
mvn test
```

## Running the application
```bash
mvn spring-boot:run
```

## About the API

```
GET /api/v1/flights - Get all flights
GET /api/v1/flights/return - Get the Return flights
```

## Built With

* [SpringBoot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management 