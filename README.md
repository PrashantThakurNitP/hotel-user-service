# 👤 User Service

## 📖 Overview

The **User Service** is a core component of the Hotel Booking System responsible for:

- User registration and authentication using **JWT**.
- Managing user profiles.
- Securing endpoints using **role-based access control**.
- Handling logout and session invalidation using **Redis**.

## 🚀 Features

- ✅ User signup and login  
- 🔐 JWT-based authentication  
- ♻️ Redis-backed token invalidation (logout/session expiry)  
- 🧾 User profile creation, update, and retrieval  
- 🧪 API documentation via Swagger  

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Security (JWT)**
- **PostgreSQL**
- **Redis**
- **Lombok**
- **Swagger (OpenAPI 3)**
- **Gradle**

## 📦 Modules

| Module               | Description                                               |
|----------------------|-----------------------------------------------------------|
| **Auth Controller**  | Endpoints for login and registration                      |
| **Profile Management** | CRUD operations for user profiles                        |
| **JWT Utilities**    | Token generation, validation, and expiration handling     |
| **Redis Store**      | Manages JWT token IDs for logout and blacklist            |
| **Security Config**  | Configures role-based access and secure endpoints         |

## 🔐 Authentication & Redis Logout Flow

1. On login, a JWT token is generated and returned to the client.
2. Token UUID is stored in Redis with an expiration time.
3. On logout, token UUID is removed or blacklisted in Redis.
4. Each incoming request validates:
   - Token signature & expiry.
   - Token UUID in Redis.

## 📘 API Documentation

Swagger UI is available at:  
**`http://localhost:8081/swagger-ui.html`**

### Sample API Endpoints

| Method | Endpoint             | Description                       |
|--------|----------------------|-----------------------------------|
| `POST` | `/api/users/register` | Register a new user               |
| `POST` | `/api/users/login`    | Authenticate user and return JWT  |
| `POST` | `/api/users/logout`   | Invalidate current session token  |
| `GET`  | `/api/profile`        | Fetch current user's profile      |
| `PUT`  | `/api/profile`        | Update current user's profile     |

## ⚙️ Setup Instructions

1. **Start services:**
   - PostgreSQL
   - Redis

2. **Configure `application.properties`:**

