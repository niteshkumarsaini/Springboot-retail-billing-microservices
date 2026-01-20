# 🧩 Retail Billing Microservices – Spring Boot

A **Spring Boot Microservices–based project** demonstrating **service discovery, clean architecture, real-world business logic, database persistence, and centralized exception handling**.  
The system consists of a **Service Registry (Eureka Server)** and a **Retail Billing Microservice** that calculates final bills based on tax and discount rules.

---

## 🏗 Architecture Overview

This project follows a **microservices architecture** using **Spring Cloud Netflix Eureka** for service discovery.

### 🔹 Microservices Included

#### 1️⃣ Service Registry (Eureka Server)
- Centralized service discovery using Netflix Eureka
- Allows microservices to dynamically register and discover each other
- Enables loose coupling and scalability

#### 2️⃣ Retail Billing Service
- Core business microservice responsible for billing calculation
- Registers itself with Eureka Server
- Exposes REST API for bill calculation
- Persists billing summary data in PostgreSQL

---

## 🧠 Business Use Case

The Retail Billing Service calculates the final bill for a retail transaction by:
- Applying **tax based on item category**
- Applying **discounts after tax calculation**
- Persisting billing details in the database
- Returning a structured API response

---

## 🚀 Tech Stack

- Java 8
- Spring Boot
- Spring Cloud Netflix Eureka
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven

---

## 📡 API Details

### ➤ Calculate Bill

**POST** `/api/billing/calculate`

### Request Body
```json
[
  { "name": "Laptop", "type": "Electronics", "price": 1000.00 },
  { "name": "Rice", "type": "Groceries", "price": 50.00 },
  { "name": "Headphones", "type": "Electronics", "price": 150.00 }
]
