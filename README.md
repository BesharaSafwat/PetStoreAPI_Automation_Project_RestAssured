# 🐾 PetStore API Automation Project (Rest Assured)

Automated testing framework for the **Swagger PetStore API** using
**Rest Assured**, covering full CRUD operations for **Pets**, **Users**,
and **Store (Orders)** modules.\
The project is built with **Maven** and integrated with **Allure
Reports** for rich and structured test reporting.

## 📌 Table of Contents

-   Project Overview
-   Technologies Used
-   Project Structure
-   Test Scenarios
-   Setup and Execution
-   Generating Allure Reports

## 🚀 Project Overview

This project automates **RESTful API testing** for the PetStore
application:

-   🐶 **Pets**
-   👤 **Users**
-   🏬 **Store (Orders)**

It validates: - API functionality\
- Response structure\
- Status codes\
- Error handling\
- Edge cases

All test execution is recorded using **Allure**, generating detailed,
interactive reports.

## 🛠 Technologies Used

  Tool                      Purpose
  ------------------------- -------------------------------
  **Java 13**               Programming language
  **Apache Maven 3.9.11**   Build & dependency management
  **IntelliJ IDEA**         IDE
  **Rest Assured**          API test automation
  **TestNG**                Test framework
  **Allure Reports**        Test reporting

## 📁 Project Structure

    ├── src
    │   ├── main
    │   │   └── java
    │   └── test
    │       └── java
    │           ├── tests          # Contains API automation test cases
    ├── allure-results             # Stores Allure report files
    ├── pom.xml                    # Maven configuration
    └── README.md                  # Project documentation

## 🧪 Test Scenarios

### 🔧 Base Test

-   Sets base URL to: **https://petstore.swagger.io/v2/**

### 🐾 Pet API

-   Add a new pet --- `POST /pet`
-   Update existing pet --- `PUT /pet`
-   Update pet name or status --- `POST /pet/{petId}`
-   Upload pet image --- `POST /pet/{petId}/uploadImage`
-   Find pet by ID --- `GET /pet/{petId}`
-   Find pets by status --- `GET /pet/findByStatus`
-   Delete pet --- `DELETE /pet/{petId}`

### 👤 User API

-   Create new user --- `POST /user`
-   Create users with list --- `POST /user/createWithList`
-   User login --- `GET /user/login`
-   Get user by username --- `GET /user/{username}`
-   Update user --- `PUT /user/{username}`
-   Delete user --- `DELETE /user/{username}`

### 🏬 Store API

-   Get inventory --- `GET /store/inventory`
-   Place an order --- `POST /store/order`
-   Get order by ID --- `GET /store/order/{orderId}`
-   Delete order --- `DELETE /store/order/{orderId}`

## ✅ Test Coverage Includes

-   Response status verification\
-   Schema & body validation\
-   Error handling\
-   Negative tests (invalid input, empty requests)

## ⚙️ Setup and Execution

### 1️⃣ Clone the Repository

    git clone https://github.com/SanjanaVarma12/petstore-api-automation-rest-assured.git

### 2️⃣ Open in Your IDE

Import as a **Maven Project**.

### 3️⃣ Run Tests

    mvn clean test

## 📊 Generating Allure Reports

### Install Allure

https://allurereport.org/docs/install/

### Generate the report

    allure serve allure-results

### Sample Report

![Allure Report](insert-image-url-here)
