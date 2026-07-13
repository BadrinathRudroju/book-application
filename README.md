# Book Application

A simple Spring Boot REST API for managing books (CRUD) using an in-memory H2 database.

## Quick Start

Prerequisites: Java 11+, Maven

Run locally:

```bash
git clone https://github.com/BadrinathRudroju/book-application.git
cd book-application
./mvnw spring-boot:run
```

App: http://localhost:8080
H2 console: http://localhost:8080/h2-console (JDBC: jdbc:h2:mem:testdb, user: sa)

## API

Base: `/api/books`

- POST `/` — create a book
- GET `/` — list books
- GET `/{id}` — get book
- PUT `/{id}` — update book
- DELETE `/{id}` — delete book

Example create payload:

```json
{ "title": "Effective Java", "author": "Joshua Bloch", "isbn": "978-0134685991", "publishedYear": 2018 }
```

## Tech

Spring Boot, Spring Data JPA, H2, Maven, Java

## Project (brief)

- entity/ — JPA entities (Book.java)
- repository/ — data access
- service/ — business logic
- controller/ — REST endpoints

Notes: In-memory DB resets on restart. Intended as a small demo/starter project.

Contributions welcome.
