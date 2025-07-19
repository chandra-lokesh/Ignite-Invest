#  **Ignite-Invest – Project Requirements Document**

---

##  1. **Project Overview**

**Problem:**
There is no simple, dedicated platform where startups and investors can discover each other based on shared funding goals and industry interests.

**Solution:**
Ignite-Invest is a web-based application that enables **startups and investors** to create profiles, search/filter based on preferences, view recommended matches, show interest, and get notified — enabling a smoother, faster connection process.

---

##  2. **Key User Roles**

###  Startup

* Can register/login
* Create and manage their profile
* View recommended investors
* Search investors based on filters
* Show interest in investors
* See who showed interest in them
* Get notified when an investor shows interest

###  Investor

* Can register/login
* Create and manage their profile
* View recommended startups
* Search startups based on filters
* Show interest in startups
* Add startups to watchlist
* See who showed interest in them
* Get notified when a startup shows interest

---

##  3. **Functional Requirements**

###  Authentication & Authorization

* JWT-based login/signup
* Role-based access (STARTUP / INVESTOR)
* Session management via token

###  User Profile Management

* Profile creation/edit
* Different form fields based on user type (Startup or Investor)
* Upload bio, select industry tags, funding stage, etc.

###  Home Feed (Recommendations)

* Based on industry tags, funding range, and location
* For Startups: list of matching Investors
* For Investors: list of matching Startups

###  Search & Filtering

* Multi-filter search for both roles
* Filters include:

  * **Industry/Tags**
  * **Funding stage**
  * **Location**
  * **Funding range or investment amount**

###  Watchlist (for Investors)

* Add/Remove startups from watchlist
* View saved startups on dashboard

###  Interest/Connection Feature

* Startup → Investor: Show Interest
* Investor → Startup: Show Interest
* Store both actions
* Duplicate interest should not be allowed
* Connection status tracking

###  Dashboard

* For Startup:

  * Number of views
  * Investors interested in them
  * Interest shown to investors
* For Investor:

  * Watchlist
  * Startups interested in them
  * Interest shown to startups

###  Notification System

* Trigger email + in-app notification:

  * When **Investor shows interest** in Startup
  * When **Startup shows interest** in Investor

---

##  4. **Non-Functional Requirements**

| NFR Category        | Description                                    |
| ------------------- | ---------------------------------------------- |
| **Performance**     | API response time < 500ms for 90% of requests  |
| **Scalability**     | Use microservices to scale independently       |
| **Security**        | Secure password storage (BCrypt), JWT for auth |
| **Maintainability** | Modular codebase, well-documented              |
| **Availability**    | At least 99% uptime                            |
| **Responsiveness**  | Mobile-friendly design using Tailwind/Vuetify  |

---

##  5. **Technology Stack**

| Layer        | Technology Used             |
| ------------ | --------------------------- |
| Frontend     | Vue.js, Pinia, Tailwind     |
| Backend      | Spring Boot (Microservices) |
| Database     | PostgreSQL                  |
| Auth         | JWT, Spring Security        |
| API Gateway  | Spring Cloud Gateway        |
| Discovery    | Eureka Server               |
| Notification | JavaMailSender / SendGrid   |
| Deployment   | Docker + GitHub Actions     |

---

##  6. **Deliverables**

| Component              | Description                                      |
| ---------------------- | ------------------------------------------------ |
|   Vue.js Frontend App  | Fully functional with routing, state mgmt        |
|   Spring Boot Services | Auth, User, Startup, Investor, Notification      |
|   PostgreSQL Schema    | Tables for Users, Profiles, Watchlist, Interests |
|   Email Notifications  | For interest actions                             |
|   API Documentation    | Swagger/OpenAPI spec                             |
|   Dockerized Services  | Each service in its own container                |

---

##  7. **Future Enhancements (Post-MVP)**

* In-app messaging system
* Pitch deck upload & view
* Calendar/meeting integration
* AI-based recommendations
* Admin dashboard
* Investor verification system
* Analytics for profile engagement

---

