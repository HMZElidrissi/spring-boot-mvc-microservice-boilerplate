# Spring Boot MVC Microservice Boilerplate

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.java.net/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Flyway](https://img.shields.io/badge/Flyway-11.2.0-blue.svg)](https://flywaydb.org/)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.22-blue.svg)](https://projectlombok.org/)
[![mapstruct](https://img.shields.io/badge/mapstruct-1.6.3-blue.svg)](https://mapstruct.org/)
[![Swagger](https://img.shields.io/badge/Swagger-3.0.0-brightgreen.svg)](https://swagger.io/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue.svg)](https://www.postgresql.org/)

A modern, production-ready Spring Boot microservice boilerplate with best practices and common patterns implemented.

## Technologies

- **Java 17**
- **Spring Boot 3.4.1**
- **Spring Web MVC**
- **Spring Data JPA**
- **Flyway 11.2.0**
- **Lombok 1.18.22**
- **Mapstruct 1.6.3**
- **Swagger 3.0.0**
- **PostgreSQL 17**

## Architecture

```
src/main/java/ma.hmzelidrissi/
├── controller/         # REST controllers
├── service/           # Business logic
├── repository/        # Data access
├── domain/           # JPA entities
├── dto/              # Data Transfer Objects
│   ├── response/     # Custom PageResponse and ErrorResponse
|   └── entity/       # DTOs for a specific entity
├── mapper/           # MapStruct mappers
├── exception/        # Custom exceptions & handler
└── config/           # Configuration classes
```
