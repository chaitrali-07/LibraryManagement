##  Group Information

**Total Members:** 2

-  Chaitrali Diwanji  
-  Priya Telange
---
#  Library Management System
The **Library Management System** is a console-based Java application designed to help manage books and user interactions in a library. It supports core operations like adding, viewing, removing, borrowing, and returning books. The system uses JDBC to connect with a PostgreSQL database and follows core Java principles including OOP and multithreading.

---

##  Features

###  Admin
- Add Book
- Remove Book
- View All Books

###  Customer
- View Available Books
- Borrow Book (uses multithreading)
- Return Book

---

##  Technologies Used

- Java (Core)
- JDBC (Java Database Connectivity)
- PostgreSQL
- Maven
- Object-Oriented Programming (Abstraction, Inheritance, Interface)
- Multithreading
---

##  Database Schema

```sql
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50),
  email VARCHAR(100),
  role VARCHAR(20)
);

CREATE TABLE books (
  id SERIAL PRIMARY KEY,
  title VARCHAR(100),
  author VARCHAR(50),
  genre VARCHAR(30),
  quantity INT
);

CREATE TABLE borrowed_books (
  id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(id),
  book_id INT REFERENCES books(id),
  borrow_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  return_date TIMESTAMP
);


---
 Dependencies 

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.1</version>
</dependency>
```

---

 Prerequisites

Java JDK 17 or higher

Apache Maven 3.8.6 or higher

PostgreSQL 15 or higher

pgAdmin (optional for GUI)



---

 📩 Contact

Name: Chaitrali Diwanji
GitHub: (your GitHub username here)
Email: (optional)


---
## screenShot
<img width="652" height="317" alt="scrrenshot" src="https://github.com/user-attachments/assets/f50d57b0-b032-4cd2-9991-8e20c6ef5e0e" />


