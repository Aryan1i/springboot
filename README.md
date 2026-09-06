# JDBC Learning ☕️

This folder contains my code and practice examples while learning **JDBC (Java Database Connectivity)**.

The goal is to understand how Java applications communicate with a relational database and how different JDBC APIs can be used to perform database operations.

## Topics Covered

### 1. JDBC Basics
- Establishing a database connection using `Connection`
- Working with `Statement`
- Working with `ResultSet`
- Try-with-resources for JDBC resources

### 2. PreparedStatement
- `PreparedStatement`
- SELECT queries
- INSERT, UPDATE and DELETE queries
- `executeQuery()`
- `executeUpdate()`
- `execute()`

### 3. Properties
- Using `.properties` files
- Reading database configuration using `Properties`
- Separating database configuration from Java code

### 4. SQL Injection
- Understanding SQL Injection
- SQL Injection using `Statement`
- Preventing SQL Injection using `PreparedStatement`

### 5. Batch Updates
- Batch processing using `Statement`
- `addBatch()`
- `executeBatch()`
- Batch updates with transactions

### 6. Transactions
- Disabling auto-commit using `setAutoCommit(false)`
- `commit()`
- `rollback()`
- Handling transaction failures using `try-catch`

### 7. BLOB
- Storing images/files in the database using BLOB
- Fetching BLOB data
- Working with `InputStream`
- Writing fetched image data to files
- Reading BLOB data using different approaches

### 8. CLOB
- Storing large text using CLOB
- Fetching CLOB data
- Working with character streams

### 9. Date Handling
- Inserting dates into the database
- Fetching dates
- Converting `String` to `Date`

### 10. Connection Pooling
- Understanding database connection pooling
- MySQL connection pooling
- HikariCP
- Using HikariCP configuration
- Working with pooled database connections

---

## Project Structure

```text
JDBC-Learning
│
└── src
    └── com
        └── aryan
            └── jdbc
                │
                ├── Basics
                ├── PreparedStatement
                ├── Properties
                ├── SQLInjection
                ├── BatchUpdate
                ├── Blob
                ├── Clob
                ├── Date
                └── ConnectionPooling
## Purpose

This is a **learning repository**, so the code consists of small, focused examples for understanding individual JDBC concepts.

As I continue learning, I will keep adding new concepts and implementations to this repository.

---

## Current Progress

**JDBC — In Progress 🚧**

More topics and implementations will be added as I continue my learning journey.
