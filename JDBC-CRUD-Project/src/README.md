# JDBC CRUD Project 🚀

A **console-based Employee Management application** developed using **Java and JDBC**.

This project was developed as part of my JDBC learning in class. It brings together the JDBC concepts I have learned so far and applies them in a complete **CRUD (Create, Read, Update, Delete)** application.

---

## 📌 Features

The application provides the following operations:

* **Insert Employee** — Add a new employee to the database
* **View Employees** — Display employee records
* **Update Employee** — Update existing employee details
* **Delete Employee** — Remove an employee from the database
* **Exit** — Close the application

---

## 🛠️ Technologies Used

* **Java**
* **JDBC (Java Database Connectivity)**
* **MySQL**
* **HikariCP** — Connection Pooling
* **Eclipse IDE**

---

## 🏗️ Project Architecture

The project follows a layered architecture to separate different responsibilities.

```text
                Main / Application
                       │
                       ▼
                  Service Layer
                       │
                       ▼
                    DAO Layer
                       │
                       ▼
                    JDBC
                       │
                       ▼
                   MySQL DB
```

### Layers

#### 1. Model

Contains the Java classes representing the data used by the application.

Example:

```text
Employee
```

The `Employee` class contains properties such as:

* ID
* Name
* Salary
* Address

---

#### 2. DAO (Data Access Object)

The DAO layer is responsible for interacting with the database.

It contains operations such as:

```text
saveEmployee()
getEmployee()
getAllEmployees()
updateEmployee()
deleteEmployee()
```

The DAO layer keeps database-related code separate from the rest of the application.

---

#### 3. Service

The Service layer contains the application's business logic.

It communicates with the DAO layer and provides a clean interface for performing employee operations.

```text
Service → DAO → Database
```

---

#### 4. Utility

The Utility layer contains reusable database-related functionality.

The project uses **HikariCP** for connection pooling, which helps efficiently manage database connections.

---

## 📂 Project Structure

```text
JDBC-CRUD-Project/
│
├── src/
│   └── com/
│       └── aryan/
│           └── jdbc/
│               ├── dao/
│               ├── model/
│               ├── service/
│               ├── utility/
│               └── ...
│
└── README.md
```

> The exact package structure may evolve as I continue learning and improving the project.

---

## 🗄️ Database

The project uses **MySQL** as the database.

### Employee Table

The application stores employee information such as:

| Column    | Description      |
| --------- | ---------------- |
| `id`      | Employee ID      |
| `name`    | Employee name    |
| `salary`  | Employee salary  |
| `address` | Employee address |

### Database Configuration

Database connection details are maintained separately from the Java code using a properties file.

Example:

```properties
db.url=jdbc:mysql://localhost:3306/your_database
db.username=your_username
db.password=your_password
```

**Note:** Actual database credentials should not be committed to GitHub.

---

## 🔄 CRUD Operations

### Create

Adds a new employee to the database.

```text
User Input
    ↓
Service
    ↓
DAO
    ↓
PreparedStatement
    ↓
MySQL
```

### Read

Retrieves employee information from the database using JDBC and `ResultSet`.

### Update

Updates the details of an existing employee using its ID.

### Delete

Deletes an employee record from the database using its ID.

---

## ▶️ How to Run

1. Clone the repository.
2. Open the project in Eclipse or another Java IDE.
3. Create the required MySQL database and employee table.
4. Configure the database connection properties.
5. Make sure the required JDBC and HikariCP dependencies are available.
6. Run the main application class.
7. Select the required operation from the console menu.

---

## 🎯 Purpose of This Project

The main purpose of this project is to apply the JDBC concepts learned in class to a complete application.

Through this project, I practiced:

* JDBC database connectivity
* `PreparedStatement`
* `ResultSet`
* CRUD operations
* DAO pattern
* Service layer
* Model classes
* Exception handling
* Database configuration using properties
* Connection pooling using HikariCP

---

## 📚 Related Learning

The individual JDBC concepts and practice programs are organized separately in:

```text
JDBC-Learning/
```

This project combines those concepts into a single CRUD-based application.

---

## 👨‍💻 Author

**Aryan Gupta**

This project is part of my journey of learning **Java Backend Development**.
