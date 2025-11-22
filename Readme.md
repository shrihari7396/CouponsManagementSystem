# 📦 Coupon Management System
A simple Spring Boot–based coupon management service that allows creating coupons with eligibility rules and retrieving the best matching coupon for a given user + cart context.

This project is built for the "Coupon Management" assignment, implementing coupon creation, updating, listing, and foundations for "best coupon" selection logic.

---
## 🚀 Project Overview
This project provides:
- API to create coupons with discount rules & eligibility conditions
- API to update coupons
- API to list all coupons
- Foundation for Best Coupon API (logic in progress)
- Uses Spring Boot + JPA with MySQL for persistence

---
## 🛠️ Tech Stack
| Layer | Technology |
|-------|------------|
| Language | Java 17 |
| Framework | Spring Boot 3 |
| ORM | Hibernate + Spring Data JPA |
| Database | MySQL |
| Build Tool | Maven |
| Others | Lombok, Spring Web |

---
## 📂 Project Structure
src/main/java/coupon/management  
│  
├── controllers  
│   └── CouponController.java  
├── entity  
│   └── Coupon.java  
├── enums  
│   ├── DiscountType.java  
│   └── UserTiers.java  
├── repository  
│   └── CouponsRepository.java  
├── services  
│   └── CouponService.java  
└── CouponManagementApplication.java

---
## 📌 Coupon Schema
### Basic Fields
- id
- code (unique)
- description
- discountType → FLAT / PERCENT
- discountValue
- maxDiscountAmount
- startDate, endDate
- usageLimitPerUser

### User Eligibility
- allowedUserTiers (CSV)
- minLifetimeSpend
- minOrdersPlaced
- firstOrderOnly
- allowedCountries (enum)

### Cart Eligibility
- minCartValue
- applicableCategories (CSV)
- excludedCategories (CSV)
- minItemsCount

---
## 📡 API Endpoints

### 1️⃣ Create Coupon — POST `/api/coupons/add`
Creates and persists a new coupon.

Request (JSON):
{
  "code": "WELCOME100",
  "description": "Flat discount for first-time users",
  "discountType": "FLAT",
  "discountValue": 100,
  "maxDiscountAmount": null,
  "startDate": "2025-01-01",
  "endDate": "2025-12-31",
  "usageLimitPerUser": 1,
  "allowedUserTiers": "NEW,REGULAR",
  "minLifetimeSpend": 0,
  "minOrdersPlaced": 0,
  "firstOrderOnly": true,
  "allowedCountries": "IN",
  "minCartValue": 500,
  "applicableCategories": "electronics,fashion",
  "excludedCategories": "grocery",
  "minItemsCount": 1
}

Success Response — 201 CREATED  
(returns same structure with generated id)

---
### 2️⃣ Update Coupon — PUT `/api/coupons/update`
Updates an existing coupon by id.

---
### 3️⃣ Get All Coupons — GET `/api/coupons/all`
Returns array of all coupons.

---
### 4️⃣ Get Best Coupon — GET `/api/coupons/getBestCoupon`
Future endpoint for best applicable coupon.

---
## ⚙️ How to Run the Project

### Prerequisites
- Java 17
- Maven
- MySQL
- Port 8081 free

### Database Setup
CREATE DATABASE rbi;

Update application.properties accordingly.

### Run
mvn spring-boot:run  
or  
mvn clean package  
java -jar target/coupon_management.jar

---
## 🧪 Tests
Recommended:
- JUnit 5
- Mockito
- SpringBootTest

---
## 🤖 AI Usage Note
AI was used for documentation, refactoring guidance, and examples.

---
## 📝 Assignment Submission Format
Name: Shrihari R. Kulkarni  
GitHub Repo: (paste here)

---
## 💡 Future Improvements
- Full best-coupon algorithm
- Replace CSV fields with ORM relations
- Add DTOs and Validations
- Add complete test suite
- Add Postman collection

---
License: MIT
