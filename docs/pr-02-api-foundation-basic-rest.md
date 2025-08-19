# PR-02: API Foundation (Web + REST)
Linked PR: [`#2`](https://github.com/akhilennu/spring-boot-samples-tldr/pull/2)

## What was done
- Added the `spring-boot-starter-web` dependency to `pom.xml` to enable web and RESTful capabilities.
- Implemented a standard layered architecture for a `Book` resource:
    - `BookController`: Handles incoming HTTP requests and delegates to the service layer.
    - `BookService`: Contains business logic. For now, it uses an in-memory `Map` to simulate a database.
    - `Book` model: A simple POJO representing a book.
    - `BookNotFoundException`: A custom runtime exception for `404 Not Found` scenarios.
- Established RESTful endpoints for basic CRUD (Create, Read, Update, Delete) operations.

## Key decisions/notes
- **Layered Architecture**: The separation of concerns (Controller for web, Service for logic) is a core principle for building scalable and maintainable applications.
- **In-Memory "Database"**: To focus purely on the API layer, an in-memory `ConcurrentHashMap` acts as our data store in the `BookService`. This avoids database setup complexity for now.
- **Constructor Injection**: The `BookController` uses constructor injection for its `BookService` dependency. This is a Spring best practice that makes dependencies explicit and required.
- **RESTful Conventions**:
    - Endpoints use a plural noun resource (`/books`).
    - HTTP verbs (GET, POST, PUT, DELETE) map directly to CRUD operations.
    - The `create` endpoint returns a `201 Created` status with a `Location` header pointing to the newly created resource, which is a REST best practice.

## How to run & test
First, run the application from the root directory:
```bash
mvn spring-boot:run
```

You can then interact with the API using a client like **httpie**. The following commands demonstrate the functionality.

### HTTPie Commands

**1. Create a new book**
```bash
http POST :8080/books title="The Hobbit" author="J.R.R. Tolkien"
```
*(This will return a `201 Created` status and the new book object)*

**2. Get a book by its ID** (assuming the book was created with ID 1)
```bash
http GET :8080/books/1
```

**3. Update an existing book**
```bash
http PUT :8080/books/1 title="The Hobbit: An Unexpected Journey" author="J.R.R. Tolkien"
```

**4. Attempt to get a book that doesn't exist** (to see the 404 error)
```bash
http GET :8080/books/999
```

**5. Delete a book**
```bash
http DELETE :8080/books/1
```
*(This will return a `204 No Content` status)*

## Next steps
- Introduce persistence with `spring-boot-starter-data-jpa` and a database like H2.
- Implement global exception handling with `@ControllerAdvice` to create consistent error responses.
- Add input validation using `spring-boot-starter-validation`.
