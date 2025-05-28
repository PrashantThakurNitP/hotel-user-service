### 📁 `user-service/README.md`

```markdown
# User Service

## 👤 Overview

The **User Service** handles user registration, authentication (JWT-based), and profile management in the Hotel Booking System.

## 🚀 Features

- User registration and login
- JWT token-based authentication
- Profile creation and updates
- Role-based access control (admin, user)

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Security (JWT)**
- **PostgreSQL**
- **Lombok**
- **Swagger (OpenAPI)**
- **Maven**

## 📦 Modules

- **Auth Controller** – Login & signup endpoints
- **Profile Management** – User profile CRUD
- **JWT Utilities** – Token creation and validation
- **Security Config** – Secure endpoints

## ⚙️ Setup

1. Start PostgreSQL and create a database.
2. Update `application.properties` with your DB and secret key.

