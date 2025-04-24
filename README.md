# Test AI Spring Boot Application

A Spring Boot project with a standard structure similar to profams_backend.

## Project Structure

```
test_ai/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── testai/
│   │   │               ├── config/          # Configuration classes
│   │   │               ├── controller/      # REST controllers
│   │   │               ├── dto/             # Data Transfer Objects
│   │   │               ├── exception/       # Custom exceptions
│   │   │               ├── model/           # JPA entities
│   │   │               ├── repository/      # Spring Data repositories
│   │   │               ├── service/         # Business logic services
│   │   │               └── TestAiApplication.java  # Main application class
│   │   └── resources/
│   │       └── application.properties       # Application configuration
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── testai/
│                       └── controller/      # Controller tests
├── .gitignore          # Git ignore file
├── pom.xml             # Maven configuration
└── README.md           # Project documentation
```

## Technologies Used

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- H2 Database (for development)
- Maven
- JUnit 5
- Lombok

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/MagdyIYounis/test_ai.git
   cd test_ai
   ```

2. Build the application:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Accessing the Application

- The API will be available at: http://localhost:8080/api
- H2 Console (if enabled): http://localhost:8080/h2-console
  - JDBC URL: jdbc:h2:mem:testdb
  - Username: sa
  - Password: password

## API Endpoints

### Users

- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create a new user
- `PUT /api/users/{id}` - Update an existing user
- `DELETE /api/users/{id}` - Delete a user

## Testing

Run the tests with:
```bash
mvn test
```
