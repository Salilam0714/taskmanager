# ✅ Task Manager API

A simple task management REST API built with Spring Boot.  
This is a learning project focused on mastering Java, Spring Boot, and software engineering best practices.

---

## 🚀 Features

- Create, read, update, and delete tasks (CRUD)
- Filter tasks by completion status (`completed=true/false`)
- Search tasks by title keyword (`search?keyword=xxx`)
- Layered architecture: Controller → Service → Repository
- In-memory H2 database for easy development/testing
- Uses Lombok for cleaner model code

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Lombok
- Maven

---

## 📂 Project Structure

taskmanager/
├── controller/ # REST controllers (TaskController)
├── service/ # Business logic (TaskService)
├── model/ # JPA entity (Task)
├── repository/ # Data access layer (TaskRepository)
└── /resources/ application.properties


---

## 🧪 Running the App

### Prerequisites

- Java 17+
- Maven
- VS Code or IntelliJ or other IDE

### Steps

```bash
# 1. Clone the repo
git clone https://github.com/Salilam0714/taskmanager.git
cd taskmanager

# 2. Run the app using Maven
./mvnw spring-boot:run

# 3. App will start at:
http://localhost:8080
```
---

### 🧪 API Endpoints (Use Postman or curl)
Method	    Endpoint                    Description
GET	        /tasks	                    Get all tasks
GET	        /tasks/{id}	                Get a task by ID
GET	        /tasks/filter?completed=	  Filter tasks by completion
GET	        /tasks/search?keyword=	    Search tasks by title
POST	      /tasks	                    Create a new task
PUT	        /tasks/{id}	                Update a task
DELETE	    /tasks/{id}	                Delete a task

---

### 💡 Example JSON(POST body)
```json
{
  "title": "Learn Spring Boot",
  "description": "Understand how to build REST APIs",
  "completed": false
}
```

---

### 📌 Future Plans
- Switch database from H2 to MySQL

- Add UI

- Add exception handling and validation

- Add unit & integration tests

---

## 🙋‍♂️ Author
- **Name**: Yingtong Lin

- **GitHub**: [@Salilam0714](https://github.com/Salilam0714)