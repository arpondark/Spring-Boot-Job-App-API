# Spring Boot Job App API

This project is a Spring Boot application that provides APIs for managing job applications. It uses PostgreSQL as the database and includes a Docker setup for easy deployment.

## Prerequisites

- Docker
- Docker Compose

## Getting Started

### Clone the repository

```bash
git clone https://github.com/arpondark/Spring-Boot-Job-App-API.git
cd Spring-Boot-Job-App-API
```
## Structure 
```
├── .gitattributes
├── .gitignore
├── .mvn
    └── wrapper
    │   └── maven-wrapper.properties
├── docker-compose.yaml
├── mvnw
├── mvnw.cmd
├── pom.xml
├── readme.md
└── src
    ├── main
           ├── java
        │   └── com
        │   │   └── arponJobApp
        │   │       └── Arpon
        │   │           ├── ArponJobAppApplication.java
        │   │           ├── Company
        │   │               ├── Company.java
        │   │               ├── CompanyController.java
        │   │               ├── CompanyRepository.java
        │   │               ├── CompanyService.java
        │   │               └── impl
        │   │               │   └── CompanyServiceImpl.java
        │   │           ├── Job
        │   │               ├── Job.java
        │   │               ├── JobController.java
        │   │               ├── JobRepository.java
        │   │               ├── JobService.java
        │   │               └── impl
        │   │               │   └── JobServiceImpl.java
        │   │           └── review
        │   │               ├── Review.java
        │   │               ├── ReviewController.java
        │   │               ├── ReviewRepository.java
        │   │               ├── ReviewService.java
        │   │               └── impl
        │   │                   └── ReviewServiceImpl.java
        └── resources
        │   └── application.properties
    └── test
        └── java
            └── com
                └── arponJobApp
                    └── Arpon
                        └── ArponJobAppApplicationTests.java
```
### Running the application

1. Start the services using Docker Compose:

    ```bash
    docker-compose up -d
    ```

2. The application will be available at `http://localhost:8080`.

### Services

- **PostgreSQL**: A relational database to store job application data.
- **pgAdmin**: A web-based database management tool for PostgreSQL.

### Configuration

The `docker-compose.yaml` file includes the configuration for the PostgreSQL and pgAdmin services.

```yaml
services:
  db:
    image: postgres
    container_name: my_postgres_db
    restart: always
    environment:
      POSTGRES_USER: arpon
      POSTGRES_PASSWORD: arpon
      POSTGRES_DB: postgres
    networks:
      - my-network
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/data/postgres

  pgadmin:
    image: dpage/pgadmin4
    container_name: pgadmin_new
    restart: always
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@example.com
      PGADMIN_DEFAULT_PASSWORD: SuperSecret
    networks:
      - my-network
    ports:
      - "5050:80"

networks:
  my-network:
    driver: bridge

volumes:
  pgdata:
```

### Accessing pgAdmin

- pgAdmin will be available at `http://localhost:5050`.
- Login with the email `admin@example.com` and password `SuperSecret`.

### Stopping the application

To stop the services, run:

```bash
docker-compose down
```

## API Endpoints

### Test Endpoints

You can test the API endpoints using tools like Postman or curl.

- **GET /api/jobs**: Retrieve a list of job applications.
- **POST /api/jobs**: Create a new job application.
- **GET /api/jobs/{id}**: Retrieve a specific job application by ID.
- **PUT /api/jobs/{id}**: Update a specific job application by ID.
- **DELETE /api/jobs/{id}**: Delete a specific job application by ID.

Example using curl:

```bash
# Get all job applications
curl -X GET http://localhost:8080/api/jobs

# Create a new job application
curl -X POST http://localhost:8080/api/jobs -H "Content-Type: application/json" -d '{"title": "Software Engineer", "description": "Job description here"}'

# Get a specific job application by ID
curl -X GET http://localhost:8080/api/jobs/1

# Update a specific job application by ID
curl -X PUT http://localhost:8080/api/jobs/1 -H "Content-Type: application/json" -d '{"title": "Updated Title", "description": "Updated description"}'

# Delete a specific job application by ID
curl -X DELETE http://localhost:8080/api/jobs/1
```

## License

This project is licensed under the MIT License.
