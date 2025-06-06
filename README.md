# 📚  Makeup-Exam-System

A Spring Boot-based web application to manage makeup (re-exam) requests for students in educational institutions. It allows students to submit re-exam requests and administrators to review and manage them efficiently.

---

## ✨ Features

- 👨‍🎓 Student registration and re-exam request submission
- 📅 Request scheduling and exam date management
- 🧾 Admin dashboard for viewing, approving, or rejecting requests
- 📊 Uses MySQL as the backend database
- 🔒 CORS enabled for front-end integration

---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot**
- **MySQL**
- **Spring Data JPA**
- **REST APIs**
- **Maven**

---

## 📁 Project Structure

springboot/

├── src/main/java/com/springboot/springboot/

│ ├── controller/ # REST Controllers

│ ├── model/ # Entity classes (Student, ReExamRequest)

│ ├── repository/ # JPA Repositories

│ ├── service/ # Service layer

│ └── SpringbootApplication.java

├── src/main/resources/

│ └── application.properties

├── pom.xml # Maven dependencies

---

## 🚀 How to Run

### 1. Clone the repository
```bash
git clone https://github.com/your-username/Makeup-Exam-System.git
cd Makeup-Exam-system
```
### 2. Configure MySQL
Create a database (e.g. makeup_exam_db) and update the credentials in:
```bash
src/main/resources/application.properties
```
In properties:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/makeup_exam_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```
### 3. Build and Run the Application
```bash
./mvnw spring-boot:run
```
---

## UML Diagram:
![image](https://github.com/user-attachments/assets/696e9dd0-dda7-4c47-afd8-694a156f2e38)

---

## 📄 Documentation

For more detailed information about the project, features, and usage, please refer to the [Project Documentation (PDF)](https://github.com/user-attachments/files/20630981/Makeup-Exam-System.pdf).

---
## 🧑‍💻 Author
Daivik Naik

📧 [daiviknaik23@gmail.com]

📌 Linkedin : www.linkedin.com/in/daiviknaik
