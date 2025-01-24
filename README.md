# Machine Test Application

This is a simple Spring Boot application that provides CRUD operations for managing categories and products with a relational database (MySQL). The application uses JPA and Hibernate for database interactions, ensuring seamless integration between the application and the database.

## Features

- **Category CRUD operations**: Allows users to create, read, update, and delete categories.
- **Product CRUD operations**: Allows users to create, read, update, and delete products.
- **Pagination**: Supports server-side pagination for fetching categories and products.
- **Relational mapping**: Categories and products are linked with a one-to-many relationship (one category can have multiple products).
- **Exception handling**: Custom runtime exceptions are thrown when a category or product is not found.

## Technologies Used

- **Spring Boot**: For building the backend.
- **JPA & Hibernate**: For object-relational mapping (ORM).
- **MySQL**: As the relational database.
- **Spring Data JPA**: For repository support and simplifying data access.
- **Thymeleaf**: If required in the future for rendering dynamic views.
- **Jackson**: For JSON serialization and deserialization.

## Requirements

- **Java 17** or higher
- **Spring Boot 2.x**
- **MySQL** (installed and running locally)
- **Maven** for building the project

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/your-username/machinetest.git
cd machinetest
