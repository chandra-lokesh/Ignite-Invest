---

# **Ignite-Invest – Project Scope Document**

---

## **Q1. What is the purpose of the project?**

**A1.**
To develop a web application that connects **investors** and **startups**, facilitating mutual discovery and engagement.

---

## **Q2. What are the main features/modules?**

**A2.**
The platform enables:

* **Startups** to search for and show interest in **investors**.
* **Investors** to search for and show interest in **startups**.
* **Personalized recommendations** for both based on preferences.

---

### **Ignite-Invest Core Features (MVP Scope)**

---

### 1. **Home Screen with Personalized Recommendations**

#### For Startups:

* Matching **investors** based on:

  * Industry
  * Funding stage
  * Funding range
  * Location

#### For Investors:

* Matching **startups** based on:

  * Industry
  * Startup stage
  * Funding needed
  * Location

---

### 2. **Advanced Search & Filtering**

#### Investors can filter startups by:

* Industry
* Stage (Idea, MVP, Revenue, etc.)
* Location
* Investment needed

#### Startups can filter investors by:

* Domain interests
* Funding range
* Preferred funding stage
* Location

---

### 3. **Profile Management**

#### Investor Profile Includes:

* Name, bio, email
* Industry interests (tags)
* Preferred funding stage
* Funding range (₹X - ₹Y)
* Location
* Watchlist (saved startups)
* Startups shown interest
* Startups that showed interest in them

#### Startup Profile Includes:

* Startup name, bio, email
* Website (optional)
* Stage (Idea, MVP, etc.)
* Industry (tags)
* Investment needed
* Number of funding rounds
* Location
* Investors shown interest
* Investors that showed interest in them

---

### 4. **User Dashboards**

#### For Startups:

* Profile views
* Interested investors
* Contacted investors
* Connection history

#### For Investors:

* Watchlist (saved startups)
* Interested startups
* Contacted startups
* Connection history

---

### 5. **Watchlist Feature**

* Available **only for investors** in MVP.
* Allows saving interesting startup profiles.
* Accessible from the dashboard.

---

### 6. **Bi-directional Interest & Connection System**

* Startup → Investor: **Show Interest**
* Investor → Startup: **Show Interest**
* Sends email and stores record in DB.
* Visible in both parties' dashboards.

---

### 7. **Notifications System**

Trigger **email + in-app notifications** when:

* A **startup shows interest** in an investor.
* An **investor shows interest** in a startup.

---

## Summary of Changes from Previous Plan

| Feature                | Update                                                          |
| ---------------------- | --------------------------------------------------------------- |
| Mutual Interest        | Startups can now also show interest in investors                |
| Email Triggers         | Both types of interest actions will trigger email notifications |
| Dashboards             | Updated to show both incoming and outgoing interests            |
| Connection Tracking    | Each interest stored in DB for both sides                       |
| Messaging              | Still not part of MVP, can be added in a future release         |

---

## **Q3. Who are the users?**

**A3.**

* **Startups**
* **Investors**

---

## **Q4. What tech stack will be used?**

**A4.**

| Layer        | Technology  |
| ------------ | ----------- |
| **Backend**  | Spring Boot |
| **Frontend** | Vue.js      |
| **Database** | PostgreSQL  |

---

