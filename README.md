# Fitness App - User Service

This project contains the initial User Service for the upcoming Fitness AI application backend. Currently, it allows users to register and retrieve their basic profile information.

## Features (Current)

* **User Registration:** Creates a new user profile with validation.
* **Get User Profile:** Retrieves profile details for a registered user.

## Technology Stack

* **Language:** Java 24
* **Framework:** Spring Boot 3.x
    * Spring Web (for REST APIs)
    * Spring Data JPA (for database interaction)
    * Spring Validation (`jakarta.validation-api` for `@Valid`)
* **Database:** H2 (In-memory, for easy startup - configurable) / PostgreSQL (Specify if used)
* **Build Tool:** Maven / Gradle (Specify which one)

## Prerequisites

* **JDK:** Version 24 installed
* **Maven / Gradle:** Version X.x installed
* **Git**

## Getting Started

1.  **Clone the repository:**
    ```bash
    git clone <your-repository-url>
    cd <your-project-directory-name>
    ```

2.  **Build the service:**
    * **Using Maven:**
        ```bash
        mvn clean install
        ```
    * **Using Gradle:**
        ```bash
        ./gradlew build
        ```

## Running the Service

You can run the service directly using your build tool or by executing the JAR file.

* **Using Maven:**
    ```bash
    mvn spring-boot:run
    ```
* **Using Gradle:**
    ```bash
    ./gradlew bootRun
    ```
* **Using JAR file:**
    ```bash
    java -jar target/user-service-*.jar
    ```
    *(Adjust JAR file name if necessary)*

The service will typically start on port `8080` (check `application.properties` or `application.yml`).

## API Endpoints

* ### Register User
    * **Endpoint:** `POST /api/users/register`
    * **Request Body:**
        ```json
        {
          "username": "testuser",
          "email": "test@example.com",
          "password": "password123",
          "firstName": "Test",
          "lastName": "User"
          // Add other relevant fields
        }
        ```
    * **Response:**
        * `201 Created`: User successfully registered. Returns the created user details (without password).
        * `400 Bad Request`: Validation failed (e.g., invalid email format, missing fields). Response body includes validation errors.

* ### Get User Profile by ID
    * **Endpoint:** `GET /api/users/{userId}`
    * **Path Variable:** `userId` - The unique identifier of the user.
    * **Response:**
        * `200 OK`: Returns the user profile details (without sensitive info like password).
            ```json
            {
              "id": "...", // User ID
              "username": "testuser",
              "email": "test@example.com",
              "firstName": "Test",
              "lastName": "User"
              // Add other relevant fields
            }
            ```
        * `404 Not Found`: User with the specified ID does not exist.

## Configuration

* Basic configuration (server port, database connection for non-H2 DBs) can be found in `src/main/resources/application.properties` or `application.yml`.
* For development, the service uses an H2 in-memory database by default.

## Future Plans

This service is the first building block. Future development will involve adding more microservices for workouts, diet, AI recommendations, and implementing security (authentication/authorization).
