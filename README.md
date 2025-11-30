# High-Performance URL Shortener Service 

## Overview
A scalable REST API designed to shorten long URLs into unique, compact keys (TinyURL clone). Built with performance and clean architecture principles in mind.

## 🛠 Tech Stack
* **Java 21** & **Spring Boot 3**
* **Database:** H2 (Dev) / PostgreSQL (Prod)
* **Caching:** Redis (Planned for v2)
* **Containerization:** Docker & Docker Compose

## ✨ Key Features (MVP)
1.  **POST /api/v1/shorten**: Accepts a long URL and returns a short alias.
2.  **GET /{alias}**: Redirects the user to the original URL (HTTP 302).
3.  **Data Validation**: Ensures URLs are valid and safe.

## 🏗 Architecture
Using a **Layered Architecture** to ensure separation of concerns:
* `Controller Layer`: Handles HTTP requests/responses.
* `Service Layer`: Contains business logic (hashing algorithms).
* `Repository Layer`: Interacts with the database.

## 🚀 Getting Started
