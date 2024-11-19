JWT Authentication Spring Boot Application

This guide provides a step-by-step setup for integrating JWT (JSON Web Token) authentication into a Spring Boot application.
The application will use Spring Security, JWT token generation, and a simple database with user roles for access control.

Prerequisites

- Java 17 or higher
- Spring Boot 3.x
- MySQL or PostgreSQL (or any database supported by Spring Data JPA)
- Maven or Gradle as build tools
- A basic understanding of Spring Boot and Spring Security

Project Setup

1. Clone or download this repository.
2. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).
3. Configure the `application.properties` or `application.yml` for your database settings.

Database Setup

1. Set up a MySQL database named `jwttest`. 
2. Ensure that the schema is set to auto-update by Spring Boot.
3. Use the following SQL script to insert initial roles and create tables:


-- SQL Script to create roles table and insert roles
CREATE TABLE IF NOT EXISTS roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Insert predefined roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');


4. In `application.properties`, configure your data source and JPA properties to auto-create and update the schema:


# Database configuration for jwttest schema
spring.datasource.url=jdbc:mysql://localhost:3306/jwttest?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

JWT and Security Setup

1. Set up JWT utility class for token generation and validation (already implemented in the project).
2. Use Spring Security's `UsernamePasswordAuthenticationFilter` to validate the token on protected endpoints.

Running the Application

1. Run the application using your IDE or command line: `mvn spring-boot:run` or `gradle bootRun`.
2. The application will start, and the schema will auto-update as long as you have the `jwttest` schema in MySQL.
3. Access the login page at `http://localhost:8080/login`.
4. After successful authentication, you will receive a JWT token stored in an HTTP-only cookie.
5. Use the token to access protected routes like `/home`.

Conclusion

This Spring Boot application demonstrates JWT-based authentication with a simple database schema for roles management.
Ensure to adjust your database configuration and security settings as needed for production environments.


Contact for more infomation asgervb@gmail.com
