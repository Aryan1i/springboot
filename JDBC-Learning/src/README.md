# JDBC Learning

This folder contains my learning and practice code for **Java Database Connectivity (JDBC)**.

I have organized the examples topic-wise based on what I have learned in class. Each topic contains code demonstrating the related JDBC concept.

## 📚 Topics Covered

### 1. JDBC Basics

* Loading JDBC Driver
* Establishing a database connection
* Creating `Statement`
* Executing SQL queries
* Processing `ResultSet`
* Closing JDBC resources

### 2. PreparedStatement

* Creating `PreparedStatement`
* Passing parameters to SQL queries
* Executing parameterized queries
* Advantages of `PreparedStatement`

### 3. Properties

* Using a properties file for database configuration
* Separating database credentials from Java code
* Reading database configuration using `Properties`

### 4. SQL Injection

* Understanding SQL Injection
* How SQL Injection can occur
* Preventing SQL Injection using `PreparedStatement`

### 5. Batch Update

* Executing multiple SQL statements as a batch
* Using `addBatch()`
* Using `executeBatch()`
* Understanding the benefits of batch processing

### 6. Transactions

* Understanding database transactions
* `commit()`
* `rollback()`
* Managing transaction boundaries using JDBC

### 7. BLOB

* Working with Binary Large Objects
* Storing binary data in a database
* Retrieving BLOB data using JDBC

### 8. CLOB

* Working with Character Large Objects
* Storing large text data
* Retrieving CLOB data using JDBC

### 9. Date

* Working with SQL date and time types
* Converting Java date/time values
* Handling date values using JDBC

### 10. Connection Pooling

* Understanding connection pooling
* Using **HikariCP**
* Creating and managing a connection pool
* Understanding the benefits of connection pooling

---

## 🛠️ Technologies Used

* **Java**
* **JDBC**
* **MySQL**
* **HikariCP**
* **Eclipse IDE**

---

## 📁 Project Structure

```text
JDBC-Learning/
│
├── JDBC-Basics/
├── PreparedStatement/
├── Properties/
├── SQL-Injection/
├── Batch-Update/
├── Transactions/
├── BLOB/
├── CLOB/
├── Date/
└── Connection-Pooling/
```

> The folder structure may evolve as I learn and add more JDBC concepts.

---

## 🎯 Purpose

The purpose of this folder is to maintain my **JDBC learning journey and practice code** in an organized way.

The examples are mainly focused on understanding individual JDBC concepts rather than building a complete application.

For a complete JDBC CRUD application, refer to the **JDBC CRUD Project** in this repository.

---

## 👨‍💻 Author

**Aryan Gupta**

This repository is part of my journey of learning **Java Backend Development**.
