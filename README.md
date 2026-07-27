# Book Application

A Spring Boot REST API for managing books with CRUD operations and in-memory H2 database.

## Prerequisites
- Java 11+
- Maven

## Quick Start

```bash
git clone https://github.com/BadrinathRudroju/book-application.git
cd book-application
./mvnw spring-boot:run
```

**Access:**
- App: http://localhost:8080
- H2 Console: http://localhost:8080/h2-console (user: `sa`, no password)

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/books/` | Create a book |
| GET | `/api/books/` | List all books |
| GET | `/api/books/{id}` | Get book by ID |
| PUT | `/api/books/{id}` | Update book |
| DELETE | `/api/books/{id}` | Delete book |

**Example Request:**
```json
{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "978-0134685991",
  "publishedYear": 2018
}
```

## Tech Stack
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Java

## Project Structure
- `entity/` — JPA entities
- `repository/` — Data access layer
- `service/` — Business logic
- `controller/` — REST endpoints

## Notes
- In-memory database resets on application restart
- Demo/starter project template
- Contributions welcome
