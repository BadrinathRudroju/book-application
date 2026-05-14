# 📚 Book Application

A Spring Boot REST API with full CRUD operations for managing books, backed by an H2 in-memory database.

## Tech Stack

- Java
- Spring Boot
- H2 Database (in-memory)

## Features

| Operation | Description |
|-----------|-------------|
| **Create** | Add a new book to the database |
| **Read**   | Retrieve and display book details |
| **Update** | Overwrite existing book details |
| **Delete** | Remove a book from the database |

## Project Structure

```
src/main/java/com/example/bookapp/
├── entity/
│   └── Book.java          # Maps to the BOOKS table; each instance = one row
├── repository/
│   └── BookRepository.java
├── service/
│   └── BookService.java
└── controller/
    └── BookController.java
```

## Entity: Book

The `Book` class is annotated with `@Entity` and acts as the schema definition for the database table. Each field maps to a column, and each saved object becomes a row.

## Getting Started

```bash
git clone https://github.com/your-username/book-application.git
cd book-application
./mvnw spring-boot:run
```

The H2 console is available at: `http://localhost:8080/h2-console`

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/books` | Add a new book |
| GET | `/books` | Get all books |
| GET | `/books/{id}` | Get a book by ID |
| PUT | `/books/{id}` | Update a book |
| DELETE | `/books/{id}` | Delete a book |
