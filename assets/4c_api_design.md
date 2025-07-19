
---

## Tech Stack Assumptions

* **Backend:** Spring Boot (Gradle)
* **Frontend:** Vue.js
* **Database:** PostgreSQL
* **Authentication:** JWT (Spring Security)
* **Communication:** REST APIs

---

## API Design Overview

We'll break it down into the following modules:

### 1. **Auth & User**

### 2. **Startup**

### 3. **Investor**

### 4. **Investments**

### 5. **Watchlist & Favorites**

### 6. **Interests**

### 7. **Recommendation APIs**

---

## 1. Auth & User APIs

| Method | Endpoint             | Description                            |
| ------ | -------------------- | -------------------------------------- |
| POST   | `/api/auth/register` | Register user (role: startup/investor) |
| POST   | `/api/auth/login`    | Login & get JWT token                  |
| GET    | `/api/users/me`      | Get current user profile               |

---

## 2. Startup APIs

| Method | Endpoint                   | Description                             |
| ------ | -------------------------- | --------------------------------------- |
| POST   | `/api/startups`            | Create startup profile                  |
| PUT    | `/api/startups/{id}`       | Update startup profile                  |
| GET    | `/api/startups/{id}`       | Get startup profile by ID               |
| GET    | `/api/startups`            | Get all startups (filters optional)     |
| GET    | `/api/startups/my-profile` | Get current logged-in startup’s profile |

---

## 3. Investor APIs

| Method | Endpoint                    | Description                              |
| ------ | --------------------------- | ---------------------------------------- |
| POST   | `/api/investors`            | Create investor profile                  |
| PUT    | `/api/investors/{id}`       | Update investor profile                  |
| GET    | `/api/investors/{id}`       | Get investor profile by ID               |
| GET    | `/api/investors`            | Get all investors (filters optional)     |
| GET    | `/api/investors/my-profile` | Get current logged-in investor’s profile |

---

## 4. Investment APIs (startup ↔ investor mapping)

| Method | Endpoint                         | Description                        |
| ------ | -------------------------------- | ---------------------------------- |
| POST   | `/api/investments`               | Create new investment mapping      |
| GET    | `/api/investments/startup/{id}`  | Get investors for a startup        |
| GET    | `/api/investments/investor/{id}` | Get startups funded by an investor |

**Body Sample (POST):**

```json
{
  "startupId": "uuid",
  "investorId": "uuid",
  "investmentAmount": 500000,
  "dateOfInvestment": "2025-07-19"
}
```

---

## 5. Watchlist & Favorites APIs

### Investor Watchlist (saved startups)

| Method | Endpoint                              | Description                         |
| ------ | ------------------------------------- | ----------------------------------- |
| POST   | `/api/watchlist/startups/{startupId}` | Add startup to investor's watchlist |
| DELETE | `/api/watchlist/startups/{startupId}` | Remove from watchlist               |
| GET    | `/api/watchlist`                      | Get current investor's watchlist    |

### Startup Favorites (saved investors)

| Method | Endpoint                                | Description                         |
| ------ | --------------------------------------- | ----------------------------------- |
| POST   | `/api/favorites/investors/{investorId}` | Add investor to startup’s favorites |
| DELETE | `/api/favorites/investors/{investorId}` | Remove from favorites               |
| GET    | `/api/favorites`                        | Get current startup’s favorites     |

---

## 6. Interest APIs (bi-directional)

| Method | Endpoint                  | Description                            |
| ------ | ------------------------- | -------------------------------------- |
| POST   | `/api/interests`          | Express interest (startup or investor) |
| GET    | `/api/interests/sent`     | Interests sent by current user         |
| GET    | `/api/interests/received` | Interests received by current user     |

**Body Sample (POST):**

```json
{
  "toUserId": "uuid"
}
```

---

## 7. Recommendation APIs (Home Screen)

| Method | Endpoint               | Description                                                                            |
| ------ | ---------------------- | -------------------------------------------------------------------------------------- |
| GET    | `/api/recommendations` | Get recommended users based on current profile (investors for startups and vice versa) |

---

## 📨 Notifications (Optional)

| Method | Endpoint             | Description                                  |
| ------ | -------------------- | -------------------------------------------- |
| GET    | `/api/notifications` | Get notifications (interests received, etc.) |

---

## Authentication Notes

* All APIs (except `/auth/*`) are **JWT protected**
* Role-based access for some routes:

  * `/api/startups/**` → ROLE\_STARTUP
  * `/api/investors/**` → ROLE\_INVESTOR

---

