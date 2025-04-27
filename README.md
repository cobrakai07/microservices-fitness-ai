# Fitness App - Backend Microservices

This project contains the backend services for the **Fitness AI** application, designed using a microservices architecture. It includes user management, AI-powered fitness recommendations, activity tracking, centralized configuration, secure API gateway, and service discovery.

---

## Architecture Overview

| Service             | Description                                                                              | Technologies                             |
|---------------------|------------------------------------------------------------------------------------------|------------------------------------------|
| **User Service**     | Manages user registration and profile information.                                       | Java 24, Spring Boot 3.x, PostgreSQL     |
| **AI Service**       | Generates fitness recommendations using Google Gemini API and RabbitMQ.                 | Java 24, Spring Boot 3.x, MongoDB, RabbitMQ |
| **Activity Service** | Tracks user fitness activities.                                                          | Java 24, Spring Boot 3.x, MongoDB        |
| **API Gateway**      | Secures and routes API requests, integrated with Keycloak for authentication (PKCE OAuth2).| Spring Cloud Gateway, Keycloak           |
| **Config Server**    | Provides centralized configuration management for all services.                         | Spring Cloud Config Server               |
| **Eureka Server**    | Enables service discovery and registration for microservices.                           | Spring Cloud Eureka                      |

---

## Technology Stack

- **Language:** Java 24
- **Frameworks:** Spring Boot 3.x, Spring Cloud
- **Databases:**
  - PostgreSQL (User Service)
  - MongoDB (AI Service, Activity Service)
- **Messaging:** RabbitMQ (Dockerized)
- **Authentication & Authorization:** Keycloak (Dockerized, OAuth2 PKCE flow)
- **Service Discovery:** Eureka Server
- **Central Configuration:** Spring Cloud Config Server
- **Build Tools:** Maven / Gradle
- **Containerization:** Docker (RabbitMQ, Keycloak)

---

## Prerequisites

- **JDK:** Java 24
- **Maven / Gradle:** Latest stable version
- **Docker & Docker Compose:** Installed and running
- **Git:** Installed

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone <your-repository-url>
cd <your-project-directory>
```

---

### 2. Run Required Docker Containers

#### Start RabbitMQ

```bash
docker run -d --hostname rabbitmq --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
```
- RabbitMQ UI: [http://localhost:15672](http://localhost:15672)
- Default Credentials: `guest` / `guest`

#### Start Keycloak

```bash
docker run -d --name keycloak -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:latest start-dev
```
- Keycloak Admin Console: [http://localhost:8181](http://localhost:8181)
- Default Credentials: `admin` / `admin`

---

### 3. Build and Run the Services

#### Using Maven

```bash
mvn clean install
mvn spring-boot:run
```

#### Using Gradle

```bash
./gradlew build
./gradlew bootRun
```

✅ Make sure **Config Server** and **Eureka Server** are started before launching other services.

---

## Service Ports (Default)

| Service | Port |
|:--------|:----:|
| Config Server | 8888 |
| Eureka Server | 8761 |
| API Gateway | 8080 |
| User Service | 8082 |
| AI Service | 8083 |
| Activity Service | 8084 |
| RabbitMQ Management | 15672 |
| Keycloak | 8181 |

---

## Key Endpoints

| Service | Method | Endpoint | Description |
|:--------|:------:|:---------|:------------|
| **User Service** | `POST` | `/api/users/register` | Register a new user |
| **User Service** | `GET` | `/api/users/{userId}` | Get user profile |
| **AI Service** | `POST` | `/api/ai/recommendation` | Generate AI fitness recommendation |
| **Activity Service** | `POST` | `/api/activities` | Log fitness activities |

---

## Security

- **API Gateway** secures all internal services.
- **Keycloak** handles OAuth2 PKCE authentication and authorization.
- **Microservices** validate tokens before processing requests.

---

## Configuration

- **Spring Cloud Config Server** hosts shared `application.yml` or `application.properties`.
- Services fetch their config dynamically on startup.
- Example configurations:
  - Database URLs
  - RabbitMQ connections
  - OAuth2 client details

---

## Future Enhancements

- Docker Compose setup for entire backend stack.
- Deploy on Kubernetes (GKE, EKS, AKS).
- Add Prometheus & Grafana for monitoring.
- Expand AI Service with real-time learning from user data.
- Notification Service for activity alerts and AI recommendations.

---

## Useful Links

- RabbitMQ Management UI: [http://localhost:15672](http://localhost:15672)
- Keycloak Admin Console: [http://localhost:8181](http://localhost:8181)
- Eureka Dashboard: [http://localhost:8761](http://localhost:8761)

---

# 🚀 Let's Build a Smarter, Fitter Future Together!
