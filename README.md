# 📚 Book Application

A modern Spring Boot REST API with full CRUD operations for managing books, backed by an H2 in-memory database. Built with clean architecture principles and best practices.

## 🚀 Quick Start

### Prerequisites
- Java 11 or higher
- Maven 3.6+

### Installation & Running

```bash
git clone https://github.com/BadrinathRudroju/book-application.git
cd book-application
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

**H2 Database Console:** http://localhost:8080/h2-console

## 🛠️ Tech Stack

| Technology | Purpose |
|-----------|---------|
| **Java** | Programming language |
| **Spring Boot** | Framework for building REST APIs |
| **Spring Data JPA** | ORM and database abstraction |
| **H2 Database** | In-memory relational database |
| **Maven** | Build and dependency management |

## 📋 Features

- ✅ **Create** - Add new books to the database
- ✅ **Read** - Retrieve all books or filter by ID
- ✅ **Update** - Modify existing book details
- ✅ **Delete** - Remove books from the database
- ✅ **In-Memory Database** - No external database setup required

## 📁 Project Structure

```
src/main/java/com/example/bookapp/
├── entity/
│   └── Book.java              # JPA Entity - Maps to BOOKS table
├── repository/
│   └── BookRepository.java    # Data access layer (extends JpaRepository)
├── service/
│   └── BookService.java       # Business logic layer
├── controller/
│   └── BookController.java    # REST API endpoints
└── BookApplicationApplication.java  # Main Spring Boot application class
```

### Architecture Layers

- **Entity Layer** - Database schema definitions (`Book.java`)
- **Repository Layer** - Database access and queries
- **Service Layer** - Business logic and data processing
- **Controller Layer** - REST API endpoints and HTTP request handling

## 📖 Entity: Book

The `Book` class is a JPA entity that maps to the `BOOKS` database table. Each field represents a column, and each saved object becomes a row in the table.

**Key Properties:**
- `id` - Unique identifier (auto-generated)
- `title` - Book title
- `author` - Author name
- `isbn` - ISBN number
- `publishedYear` - Publication year
- And more...

## 🔌 API Endpoints

### Base URL
```
http://localhost:8080/api/books
```

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|---------------|
| **POST** | `/` | Create a new book | Book JSON |
| **GET** | `/` | Get all books | - |
| **GET** | `/{id}` | Get book by ID | - |
| **PUT** | `/{id}` | Update a book | Book JSON |
| **DELETE** | `/{id}` | Delete a book | - |

### Example Requests

**Create a Book (POST)**
```bash
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Effective Java",
    "author": "Joshua Bloch",
    "isbn": "978-0134685991",
    "publishedYear": 2018
  }'
```

**Get All Books (GET)**
```bash
curl http://localhost:8080/api/books
```

**Get Book by ID (GET)**
```bash
curl http://localhost:8080/api/books/1
```

**Update a Book (PUT)**
```bash
curl -X PUT http://localhost:8080/api/books/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Effective Java (3rd Edition)",
    "author": "Joshua Bloch",
    "isbn": "978-0134685991",
    "publishedYear": 2018
  }'
```

**Delete a Book (DELETE)**
```bash
curl -X DELETE http://localhost:8080/api/books/1
```

## 💾 Database

### H2 Console Access

1. Navigate to: `http://localhost:8080/h2-console`
2. **Driver Class:** `org.h2.Driver`
3. **JDBC URL:** `jdbc:h2:mem:testdb`
4. **User Name:** `sa`
5. **Password:** (leave empty)

The database is in-memory and resets on application restart.

## 🔍 Example Response

```json
{
  "id": 1,
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "978-0134685991",
  "publishedYear": 2018
}
```

## 📦 Dependencies

Key dependencies in `pom.xml`:
- `spring-boot-starter-web` - Web and REST support
- `spring-boot-starter-data-jpa` - JPA and Hibernate
- `h2` - In-memory database
- `spring-boot-starter-test` - Testing framework

## 🤝 Contributing

Feel free to fork this project, make improvements, and submit pull requests!


## 🙋 Support

For issues, questions, or suggestions, please open an issue on GitHub.

---

**Happy Coding!** 📚✨
