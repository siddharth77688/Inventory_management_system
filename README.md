# 📦 StockFlow Inventory Management System

##  Overview

StockFlow is a **B2B SaaS Inventory Management System** designed to help businesses manage products across multiple warehouses and track inventory efficiently.

This project demonstrates a **real-world backend architecture** using Spring Boot, focusing on scalability, clean code, and business logic handling.

---

##  Key Features

*  Product Creation with SKU validation
*  Multi-Warehouse Inventory Management
*  Low Stock Alerts System
*  Input Validation using DTOs
*  Global Exception Handling
*  Clean Layered Architecture (Controller → Service → Repository)

---

##  Architecture

The project follows a **layered architecture**:

```
Controller → Service → Repository → Database
```

* **Controller** → Handles HTTP requests
* **Service** → Business logic & transactions
* **Repository** → Database interaction using JPA
* **Entity** → Database models
* **DTO** → API request/response structure

---

## 🧱 Tech Stack

* **Java 21**
* **Spring Boot**
* **Spring Data JPA (Hibernate)**
* **MySQL**
* **Lombok**

---

## ⚙️ Setup Instructions

### Clone Repository

```
git clone https://github.com/your-username/stockflow-inventory.git
cd stockflow-inventory
```

---

###  Configure Database

Create MySQL database:

```
CREATE DATABASE stockflow_db;
```

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/stockflow_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

###  Run Application

```
mvn spring-boot:run
```

---

##  API Endpoints

###  Create Product

**POST** `/api/products`

Request Body:

```
{
  "name": "Laptop",
  "sku": "LAP-001",
  "price": 50000,
  "warehouseId": 1,
  "initialQuantity": 10
}
```

---

###  Low Stock Alerts

**GET** `/api/companies/{companyId}/alerts/low-stock`

Response:

```
{
  "alerts": [
    {
      "productId": 1,
      "productName": "Laptop",
      "sku": "LAP-001",
      "warehouseId": 1,
      "currentStock": 5,
      "threshold": 10,
      "daysUntilStockout": 5
    }
  ],
  "totalAlerts": 1
}
```

---

##  Design Decisions

*  **Inventory Table Separation**

  * Enables multi-warehouse support

*  **SKU Unique Constraint**

  * Prevents duplicate products

*  **Transactional Service Layer**

  * Ensures data consistency

*  **DTO + Validation**

  * Prevents invalid API input

---

##  Assumptions

* SKU is globally unique
* Each product initially belongs to one warehouse
* Default low stock threshold = 10
* Daily usage for stockout estimation is fixed

---

##  Limitations / Future Improvements

*  Add **Company Entity & Filtering**
*  Add **Supplier-Product Mapping (Many-to-Many)**
*  Implement **Recent Sales Filtering**
*  Add **JWT Authentication**
*  Use **Redis for caching alerts**
*  Add **Docker Deployment**

---
