# Wallet API

A Spring Boot RESTful API for managing user wallets. Supports creating wallets, adding funds, debiting funds, and retrieving wallet balances. Built with **Spring Boot**, **Spring Data JPA**, **Jakarta Validation**, and supports **H2** or **PostgreSQL** databases.

---

## Features

- Create a wallet for a user
- Add funds to a wallet
- Debit funds from a wallet
- Get current wallet balance
- Global error handling with structured JSON responses
- Input validation for fields like positive amounts
- Swagger/OpenAPI documentation

---

## Tech Stack

- Java 25
- Spring Boot 4.0.3
- Spring Data JPA
- H2 / PostgreSQL database
- Jakarta Validation
- Lombok
- Swagger/OpenAPI for API documentation

---

### Getting Started
1. Clone the repository.
2. Build the project: `mvn clean install`
3. Run the application: `mvn spring-boot:run`
4. Access the API documentation in your browser: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.index.html)


### Clone the repository
```bash
git clone https://github.com/your-username/wallet-api.git
cd wallet-api

