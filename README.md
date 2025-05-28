# User Service

## 👤 Overview

The **User Service** handles user registration, authentication (JWT-based), and profile management for the Hotel Booking System. It ensures secure access to the system using role-based access control and manages session expiry via Redis.

## 🚀 Features

- User registration and login
- JWT token-based authentication
- Redis-backed token expiry handling (logout/session invalidation)
- Profile creation and updates

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Security (JWT)**
- **PostgreSQL**
- **Redis** (for managing JWT token expiry)
- **Lombok**
- **Swagger (OpenAPI)**
- **Maven**

## 📦 Modules

- **Auth Controller** – Login & signup endpoints
- **Profile Management** – User profile CRUD
- **JWT Utilities** – Token creation, validation, and expiration
- **Redis Store** – Stores token identifiers to handle logout and session expiry
- **Security Config** – Secures endpoints using Spring Security

## ⚙️ Setup

1. Start PostgreSQL and Redis.
2. Update `application.properties` with your database credentials, JWT secret, and Redis connection.
