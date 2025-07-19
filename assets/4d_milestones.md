
---

##  Total Timeline: 6–8 Weeks

---

###  **Week 1: Project Setup & Core Design**

**Goal:** Prepare groundwork and finalize structure
**Tasks:**

* Set up monorepo or microservices (start with monolithic or modular backend for MVP)
* Initialize Spring Boot with Gradle
* Set up PostgreSQL DB
* Create database schema (based on finalized ER diagram)
* Add core entities and repositories
* Set up Flyway or Liquibase (optional)

---

###  **Week 2: Auth & User Module**

**Goal:** Implement secure login/register
**Tasks:**

* Spring Security + JWT (Login, Register)
* Role-based access: STARTUP / INVESTOR
* User profile APIs (get self, get by ID)

---

###  **Week 3: Investor & Startup Profiles**

**Goal:** Create profiles and update APIs
**Tasks:**

* Investor profile APIs (create, update, get, list)
* Startup profile APIs (create, update, get, list)
* Add filtering (by domain, stage, etc.)

---

###  **Week 4: Investments, Watchlist & Favorites**

**Goal:** Implement investor-startup linking features
**Tasks:**

* Add investment mapping APIs
* Add watchlist for investors
* Add favorites for startups

---

###  **Week 5: Interest System & Recommendations**

**Goal:** Enable expression of interest and smart discovery
**Tasks:**

* Interest table + APIs (investor ↔ startup)
* Email notifications on interest
* Simple matching algorithm (recommend based on tags/stage/domain)

---

###  **Week 6: Testing & Polishing Backend**

**Goal:** Cleanup, finalize & test
**Tasks:**

* Postman collections for all APIs
* Dummy data seeding
* Swagger/OpenAPI documentation
* Error handling, logging
* Refactor repetitive code

---

###  **Week 7–8: Learn & Build Frontend (Vue.js)**

**Goal:** Learn Vue.js and implement frontend
**Tasks:**

* Learn core Vue (Vue instance, components, routing, props, events)
* Set up Vue CLI & project structure
* Pages:

  * Auth (Login/Register)
  * Dashboard (based on role)
  * Profile pages (create/update/view)
  * List/Detail view of Startups & Investors
  * Watchlist/Favorites UI
* Axios API integration
* Routing & role-based guards

---

##  Optional Extras (After MVP)

* Pitch deck upload
* Meeting scheduling
* Admin dashboard
* Email service with templates
* Deploy to Render/Vercel + Railway + PostgreSQL

---

Would you like a Notion template or Google Sheet version of this roadmap for tracking? I can also give you a Day-wise breakdown for Week 1 to get started.
