# **Architecture Design**


We'll cover:

1. **High-Level Architecture Diagram**
2. **Microservices Breakdown**
3. **Database Design (Overview)**
4. **API Gateway & Service Discovery**
5. **Security Architecture**
6. **Tech Stack Recap**

---

## 1. High-Level Architecture Diagram

```plaintext
                        +----------------------+
                        |   Frontend (Vue.js)  |
                        |----------------------|
                        | Vue Router, Pinia    |
                        +----------+-----------+
                                   |
                        HTTP (via Axios / REST)
                                   ↓
                       +-----------+-----------+
                       |  API Gateway (Spring) |
                       | Zuul / Spring Cloud   |
                       +-----------+-----------+
                                   ↓
        +-----------+----------+----------+-----------+
        |           |          |          |           |
        ↓           ↓          ↓          ↓           ↓
+---------------+ +--------------+ +-------------+ +---------------+
| Auth-Service  | | User-Service | | InvestorSvc | | StartupSvc    |
| (Login/JWT)   | | (Profile Mgmt)| | (Watchlist, | | (Dashboard,   |
|               | |              | | Interests)  | | Interests)    |
+---------------+ +--------------+ +-------------+ +---------------+
        ↓                                               ↓
+------------------+                         +----------------------+
| NotificationSvc  |                         | Search & Filter Svc  |
| (Email sender)   |                         | (Tag-based matching) |
+------------------+                         +----------------------+
```

---

## 2. Microservices Breakdown

| Service Name                  | Responsibilities                                           |
| ----------------------------- | ---------------------------------------------------------- |
| **Auth-Service**              | Login/Register, JWT, role-based access (Investor/Startup)  |
| **User-Service**              | Common user entity & shared profile details                |
| **Investor-Service**          | Investor profile, preferences, watchlist, interest history |
| **Startup-Service**           | Startup profile, funding stage, interest history           |
| **Notification-Service**      | Email notifications on “Show Interest”                     |
| **Search-Service**            | Search + filter APIs                                       |
| **API Gateway**               | Single entry point (Zuul or Spring Cloud Gateway)          |
| **Config Server (optional)**  | Externalized config for microservices                      |
| **Discovery Server (Eureka)** | Service registry for discovery                             |

---

## 3. Database Design (Overview)

### Core Tables:

#### User Table (Auth DB)

| Field     | Type                     |
| --------- | ------------------------ |
| id (UUID) | Primary Key              |
| email     | String                   |
| password  | String (hashed)          |
| role      | ENUM (STARTUP, INVESTOR) |

#### Startup Table

| Field              | Type      |
| ------------------ | --------- |
| id                 | UUID      |
| user\_id (FK)      | UUID      |
| startup\_name      | String    |
| stage              | ENUM      |
| bio                | Text      |
| industry\_tags     | String\[] |
| investment\_needed | Number    |
| rounds\_completed  | Number    |
| location           | String    |

#### Investor Table

| Field               | Type      |
| ------------------- | --------- |
| id                  | UUID      |
| user\_id (FK)       | UUID      |
| name                | String    |
| bio                 | Text      |
| interests           | String\[] |
| funding\_range\_min | Number    |
| funding\_range\_max | Number    |
| stage\_preference   | ENUM      |
| location            | String    |

#### Interests Table (Bi-directional)

| Field          | Type                           |
| -------------- | ------------------------------ |
| id             | UUID                           |
| from\_user\_id | UUID                           |
| to\_user\_id   | UUID                           |
| timestamp      | DateTime                       |
| status         | ENUM (PENDING, ACCEPTED, etc.) |

#### Watchlist Table

| Field             | Type        |
| ----------------- | ----------- |
| investor\_id (FK) | UUID        |
| startup\_id (FK)  | UUID        |
| added\_on         | DateTime    |

---

## 4. Security Architecture

* JWT Authentication (Spring Security)
* Role-based access: restrict endpoints to `STARTUP` or `INVESTOR`
* API Gateway handles token parsing
* Services validate token (with shared JWT secret or public key)
* Passwords hashed (BCrypt)

---

## 5. Notification Flow (Email)

* **Event-Driven Pattern**

  * When a user shows interest:

    * `StartupService` or `InvestorService` pushes an event (`ShowInterestEvent`)
    * `NotificationService` listens and sends an email

> Optionally: use Kafka or RabbitMQ for scalable async messaging

---

## 6. Tech Stack Recap

### Frontend:

* **Vue.js** (Composition API)
* Vue Router
* Pinia (State Mgmt)
* TailwindCSS / Vuetify

### Backend:

* **Spring Boot (Microservices)**
* Spring Security (JWT)
* Spring Data JPA (PostgreSQL)
* Eureka (Service Discovery)
* Spring Cloud Gateway or Zuul (API Gateway)
* Feign Clients for inter-service calls
* Lombok, MapStruct, ModelMapper

### Others:

* PostgreSQL
* Docker (Containerization)
* Email: SendGrid / JavaMailSender
* GitHub Actions (CI/CD)
* AWS (Optional): S3 for storage, SES for emails

---

