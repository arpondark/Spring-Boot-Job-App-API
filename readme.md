# Arpon Job Application

This is a simple Spring Boot application for managing job postings. It provides RESTful APIs to create, read, update, and delete job postings.

## Project Structure

```
/c:/Users/Administrator/Pictures/Arpon
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── arponJobApp
│   │   │   │   │   ├── Arpon
│   │   │   │   │   │   ├── Job
│   │   │   │   │   │   │   ├── Job.java
│   │   │   │   │   │   │   ├── JobService.java
│   │   │   │   │   │   │   ├── jobController.java
│   │   │   │   │   │   │   └── impl
│   │   │   │   │   │   │       └── JobServiceImpl.java
│   │   │   │   │   │   └── Application.java
│   │   └── resources
│   │       └── application.properties
└── README.md
```

## Endpoints

### Get all jobs
```
GET /jobs
```
Response: `200 OK`
```json
[
    {
        "id": 1,
        "title": "Software Engineer",
        "description": "Develop software applications",
        "minSalary": 50000,
        "maxSalary": 100000,
        "location": "New York"
    }
]
```

### Get job by ID
```
GET /jobs/{id}
```
Response: `200 OK` or `404 Not Found`
```json
{
    "id": 1,
    "title": "Software Engineer",
    "description": "Develop software applications",
    "minSalary": 50000,
    "maxSalary": 100000,
    "location": "New York"
}
```

### Create a new job
```
POST /jobs
```
Request Body:
```json
{
    "title": "Software Engineer",
    "description": "Develop software applications",
    "minSalary": 50000,
    "maxSalary": 100000,
    "location": "New York"
}
```
Response: `201 Created`
```json
"Job is added successfully"
```

### Update a job
```
PUT /jobs/{id}
```
Request Body:
```json
{
    "title": "Senior Software Engineer",
    "description": "Develop and design software applications",
    "minSalary": 70000,
    "maxSalary": 120000,
    "location": "San Francisco"
}
```
Response: `200 OK` or `404 Not Found`
```json
"Job is updated successfully"
```

### Delete a job
```
DELETE /jobs/{id}
```
Response: `200 OK` or `404 Not Found`
```json
"Job is deleted successfully"
```

## Running the Application

1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using your preferred IDE or using the command:
   ```
   ./mvnw spring-boot:run
   ```

## Dependencies

- Spring Boot
- Spring Web

## License

This project is licensed under the MIT License.