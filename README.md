# Billing Microservice

This project is a Spring Boot-based billing engine microservice with REST APIs for managing policies, premium schedules, and payment records. It uses an in-memory H2 database and is containerized for easy testing with Docker.

## Features
- Retrieve premium schedules for a policy
- Record a payment attempt and its result (success/failure)
- Return a list of delinquent policies
- Trigger a retry action for failed payments

## Prerequisites
- [Docker](https://www.docker.com/products/docker-desktop) installed
- (Optional) [curl](https://curl.se/) or [Postman](https://www.postman.com/) for API testing

## Build and Run with Docker (Spring Boot Buildpacks)

1. **Build the Docker image using Spring Boot Buildpacks:**
   
   Open a terminal in the project root and run:
   ```sh
   ./gradlew bootBuildImage --imageName=billing-service
   ```
   This will build a Docker image named `billing-service` using Cloud Native Buildpacks. No Dockerfile is required.

2. **Run the container:**
   ```sh
   docker run -p 8080:8080 billing-service
   ```
   The service will be available at [http://localhost:8080](http://localhost:8080)

3. **Access the H2 Console (optional):**
   - URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - JDBC URL: `jdbc:h2:mem:testdb`
   - User: `sa`
   - Password: `password`

## API Endpoints

### 1. Get Premium Schedules for a Policy
- **GET** `/api/policies/{policyId}/premium-schedule`
- **Response:** List of premium schedules for the policy

### 2. Get Delinquent Policies
- **GET** `/api/policies/delinquent`
- **Response:** List of delinquent policies

### 3. Process a Payment
- **POST** `/api/payment/process`
- **Body:**
  ```json
  {
    "policyId": "POL123",
    "amount": 100.00,
    "paymentMethod": "CREDIT_CARD"
  }
  ```
- **Response:**
  - `201 Created` with payment ID if successful
  - `502 Bad Gateway` with payment ID if failed

### 4. Retry a Payment
- **GET** `/api/payment/retry?id={paymentId}`
- **Response:**
  - `200 OK` if retried successfully
  - `404 Not Found` if payment ID does not exist

## Example curl Commands

**Process a Payment:**
```sh
curl -X POST http://localhost:8080/api/payment/process \
  -H "Content-Type: application/json" \
  -d '{"policyId":"POL123","amount":100.00,"paymentMethod":"CREDIT_CARD"}'
```

**Get Premium Schedules:**
```sh
curl http://localhost:8080/api/policies/POL123/premium-schedule
```

**Get Delinquent Policies:**
```sh
curl http://localhost:8080/api/policies/delinquent
```

**Retry a Payment:**
```sh
curl "http://localhost:8080/api/payment/retry?id=a1b2c3d4e5f6g7h8"
```

## Notes
- The database is in-memory and resets on container restart.
- Sample data is loaded automatically from `data.sql`.
- Enum values are case-sensitive and must match those in the code.

## Troubleshooting
- If you change code, rebuild the JAR and Docker image:
  ```sh
  ./gradlew clean build
  ./gradlew bootBuildImage --imageName=billing-service
  ```
- If the H2 console is not accessible, check `application.yaml` for H2 settings.

---

**Happy testing!**
