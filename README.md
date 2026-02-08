# 🎬 Movie API (Spring Boot REST API)

This is a simple Java backend project built using **Spring Boot** that provides a RESTful API for managing a collection of movies (similar to Netflix).

The application supports CRUD operations such as adding a movie, fetching movies, updating movie details, and deleting movies.

This project uses an **in-memory data store (ArrayList)** instead of a database.



## 🚀 Features

✅ Add a new movie  
✅ Get movie by ID  
✅ Get all movies  
✅ Update movie by ID  
✅ Delete movie by ID  
✅ In-memory storage using ArrayList  
✅ DTO based request/response structure  
✅ ModelMapper used for DTO to Entity conversion  



## 🛠️ Tech Stack Used

- Java 17+
- Spring Boot
- Spring Web (REST API)
- ModelMapper
- Maven
- In-memory storage (ArrayList)



## 📌 Project Structure

movie-api/
│
├── controller/
│ ├── MovieController.java
│ ├── StatusController.java
│
├── dto/
│ ├── MovieRequestDto.java
│ ├── MovieResponseDto.java
│
├── entity/
│ ├── Movie.java
│
├── repository/
│ ├── MovieRepository.java
│
├── service/
│ ├── MovieService.java
│
├── service/impl/
│ ├── MovieServiceImpl.java
│
└── MovieApiApplication.java



## 🧾 Item Model (Movie Entity)

Each movie contains the following fields:

| Field        | Type    | Description |
|-------------|---------|-------------|
| id          | int     | Unique movie id (auto-generated) |
| title       | String  | Movie title |
| description | String  | Movie description |
| genre       | String  | Movie genre (Action, Comedy, etc.) |
| rating      | Long    | Movie rating |



## 📌 API Endpoints

### ✅ 1. Check Application Status

GET `/checkstatus`

Response:
Application is running successfully



### ✅ 2. Add a New Movie

POST `/movie`

Request Body:
{
  "title": "KGF",
  "description": "Action Movie",
  "genre": "Action",
  "rating": 5
}

Response:
{
  "id": 1,
  "title": "KGF",
  "description": "Action Movie",
  "genre": "Action",
  "rating": 5
}



### ✅ 3. Get All Movies

GET `/movie`

Response:
  {
    "id": 1,
    "title": "KGF",
    "description": "Action Movie",
    "genre": "Action",
    "rating": 5
  },
  {
    "id": 2,
    "title": "Pushpa",
    "description": "Drama Movie",
    "genre": "Drama",
    "rating": 4
  }




### ✅ 4. Get Movie By ID

GET `/movie/{id}`

Example:
GET `/movie/1`

Response:
{
  "id": 1,
  "title": "KGF",
  "description": "Action Movie",
  "genre": "Action",
  "rating": 5
}



### ✅ 5. Update Movie By ID

PUT `/movie/{id}`

Example:
PUT `/movie/1`

Request Body:
{
  "title": "KGF Chapter 2",
  "description": "Blockbuster Action Movie",
  "genre": "Action",
  "rating": 5
}

Response:
{
  "id": 1,
  "title": "KGF Chapter 2",
  "description": "Blockbuster Action Movie",
  "genre": "Action",
  "rating": 5
}



### ✅ 6. Delete Movie By ID

DELETE `/movie/{id}`

Example:
DELETE `/movie/1`

Response:
Movie Deleted Successfully with id: 1



## ⚙️ How to Run the Project Locally

### ✅ Step 1: Clone the Project
git clone <your-github-repository-url>

### ✅ Step 2: Open in IntelliJ / Eclipse
Open the project in your IDE.

### ✅ Step 3: Run the Application
Run the main class:
MovieApiApplication.java

### ✅ Step 4: Application will start on:
http://localhost:8080



## 🧪 Testing the API

You can test APIs using:
- Postman
- Browser (GET endpoints)
- Curl commands

Example Curl Request:
curl -X GET http://localhost:8080/movie



## ⚠️ Important Notes

- This project uses **in-memory storage**, so all data will be deleted when the server restarts.
- IDs are auto-generated using an internal counter.
- This project is made for learning REST API concepts and CRUD operations.



## 👨‍💻 Developer

Name: Himanshu  
Email : Himanshukashyap6411@gmail.com
Project: Movie REST API (Spring Boot)  
Purpose: Internship / Backend Developer Task / REST API Practice  
