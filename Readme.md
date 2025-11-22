# 📦 Coupon Management System  
A simple Spring Boot–based coupon management service that allows creating coupons with eligibility rules and retrieving the best matching coupon for a given user + cart context.

This project is built for the **"Coupon Management" assignment**, implementing coupon creation, updating, listing, and foundations for "best coupon" selection logic.

---

## 🚀 Project Overview  
This project provides:

- **API to create coupons** with discount rules & eligibility conditions  
- **API to update coupons**  
- **API to list all coupons**  
- **Foundation for Best Coupon API** (logic in progress)  
- Uses **Spring Boot + JPA** with MySQL for persistence  

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

![Uploading image.png…]()

---

## 📌 Coupon Schema

### Basic Fields
- `id`
- `code` *(unique)*
- `description`
- `discountType` → FLAT / PERCENT
- `discountValue`
- `maxDiscountAmount`
- `startDate`, `endDate`
- `usageLimitPerUser`

### User Eligibility
- `allowedUserTiers` (CSV)
- `minLifetimeSpend`
- `minOrdersPlaced`
- `firstOrderOnly`
- `allowedCountries` (enum)

### Cart Eligibility
- `minCartValue`
- `applicableCategories` (CSV)
- `excludedCategories` (CSV)
- `minItemsCount`

---

## 📡 API Endpoints

### **1️⃣ Create Coupon**  
**POST** `/api/coupons/add`

Example request:

```json
{
  "code": "WELCOME100",
  "description": "Flat discount",
  "discountType": "FLAT",
  "discountValue": 100,
  "startDate": "2025-01-01",
  "endDate": "2025-12-31"
}

