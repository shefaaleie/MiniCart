# 🛒 MiniCart

MiniCart is a full-stack e-commerce application built using **React, Spring Boot, and MySQL**.

This project was created to gain practical experience in building and integrating a complete full-stack application, particularly connecting a React frontend with a Spring Boot backend through REST APIs.

---

## 🎯 Project Purpose

My stronger foundation has primarily been in **Java and Spring Boot backend development**.

After recently learning React, I wanted to gain hands-on experience implementing a frontend alongside a backend application. MiniCart was created as a practical project to understand how different parts of a full-stack application work together.

The project focuses on:

- Building a React frontend
- Developing REST APIs using Spring Boot
- Integrating frontend and backend
- Managing application data using MySQL
- Implementing core e-commerce and cart functionality

---

## ✨ Features

### 🏷️ Category Management

- Display product categories
- Fetch category data from the backend

### 🛍️ Product Management

- Display products
- Fetch product data from the Spring Boot backend
- Store and manage product information using MySQL

### 🛒 Shopping Cart

- Add products to the cart
- Increase product quantity
- Decrease product quantity
- Remove products from the cart
- Calculate the total cart price

### 🔗 Full-Stack Integration

- React frontend communicates with the Spring Boot backend
- REST APIs are used for data communication
- Application data is managed using MySQL

---

## 🚧 Work in Progress

The project is currently under development.

The **Checkout and Order functionality** is currently being implemented.

An `OrderEntity` has already been created, and the next step is to complete the order placement and checkout process.

---

## 🛠️ Technology Stack

### Frontend

- React
- JavaScript
- Vite
- CSS

### Backend

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

### Database

- MySQL

### Tools

- Git
- GitHub
- VS Code
- Eclipse / Spring Tool Suite
- MySQL Workbench

---

## 🏗️ Application Architecture

```text
React Frontend
       │
       │ REST APIs
       ▼
Spring Boot Backend
       │
       │ Spring Data JPA / Hibernate
       ▼
MySQL Database
```

---

## 📁 Project Structure

```text
MiniCart
│
├── Backend
│   └── MiniCart2
│       ├── src
│       │   ├── main
│       │   │   ├── java
│       │   │   │   └── com/example/demo
│       │   │   │       ├── controller
│       │   │   │       ├── entity
│       │   │   │       ├── repositories
│       │   │   │       └── service
│       │   │   └── resources
│       │   └── pom.xml
│
└── Frontend
    └── Mini_Cart_Project
        ├── src
        │   ├── components
        │   ├── pages
        │   └── assets
        ├── public
        └── package.json
```

---

## ⚙️ How to Run the Project

### Prerequisites

Make sure you have installed:

- Java
- Node.js
- MySQL

### Backend Setup

1. Navigate to the backend directory:

```bash
cd Backend/MiniCart2
```

2. Configure your MySQL database connection in:

```text
src/main/resources/application.properties
```

3. Run the Spring Boot application.

### Frontend Setup

1. Navigate to the frontend directory:

```bash
cd Frontend/Mini_Cart_Project
```

2. Install dependencies:

```bash
npm install
```

3. Start the application:

```bash
npm run dev
```

---

## 🔮 Future Improvements

- Complete checkout functionality
- Complete order placement functionality
- Improve error handling
- Improve user interface and user experience
- Add authentication and authorization
- Add order history
- Improve application validation
- Deploy the application

---

## 👩‍💻 Author

**Shefali Chuhan**

Java & Spring Boot Developer | Aspiring Full-Stack Developer

GitHub: https://github.com/shefaaleie

---

⭐ This project is actively being developed as part of my journey toward becoming a stronger full-stack software developer.
