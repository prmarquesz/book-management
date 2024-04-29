# Book Management

A RESTful API using Java and Spring Boot for a simple book management system.

## Setup

1. **Prerequisites:**
    - Java 21
    - Maven 3.9.5

2. **Clone the repository:**

    ```bash
    git clone https://github.com/prmarquesz/book-management.git
    cd book-management
    ```

3. **Build the project:**

   If you have Maven installed, you can build the project using the following command:

    ```bash
    mvn clean install
    ```

## Run

1. **Run the application:**

   If you have Maven installed, you can run the application using the following command:

    ```bash
    mvn spring-boot:run -Dspring-boot.run.profiles=dev -Dspring-boot.run.arguments=--JWT_SECRET=yourSecretKey
    ```
   Replace `yourSecretKey` with your actual secret key.

## Test

The application uses H2 in-memory database for testing. The database is automatically populated with test data.

1. Run maven tests

```bash 
mvn test
```

2. Run PITest
To run PITest via command line, you can use the mvn command followed by the org.pitest:pitest-maven:mutationCoverage goal. Here's how you can do it:
Open a terminal.
Navigate to your project directory using the cd command.
Run the following command:

```bash 
mvn org.pitest:pitest-maven:mutationCoverage
```

This command will run PITest on your project and generate a report in the target/pit-reports directory.
Open the index.html file in the target/pit-reports directory to view the PITest report.

## API Documentation

The API documentation is available at `http://localhost:8080/swagger-ui.html` when the application is running.
The user and password default located in `src/main/resources/db/migration/V2__create-table-users.sql` are `admin` and `123456`, respectively.
Request `/auth` with the `user` and `password` to get the JWT token.
