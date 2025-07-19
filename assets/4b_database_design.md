
---

## **ER Diagram – Ignite-Invest**

```
+----------------+
|     users      |
+----------------+
| user_id (PK)   |
| email          |
| password       |
| role           |  -- ENUM('STARTUP', 'INVESTOR')
+----------------+
       | 1
       |
       |---------------------------+
       |                           |
     1 |                         1 | 
+--------------+           +---------------+
|   startups   |           |   investors   |
+--------------+           +---------------+
| startup_id(PK)|          | investor_id(PK)|
| user_id (FK)  |          | user_id (FK)   |
| name          |          | name           |
| bio           |          | bio            |
| stage         |          | funding_stage  |
| industry_tags |          | interests_tags |
| location      |          | location       |
| website       |          | funding_min    |
| email         |          | funding_max    |
| funding_needed|          |                |
| rounds        |          |                |
+--------------+           +---------------+
       |                            |
       |                            |
       ↓                            ↓
+---------------------------+  
|   startup_investor_map    |   <-- M:N investment mapping
+---------------------------+
| id (PK)                   |
| startup_id (FK)           |
| investor_id (FK)          |
| investment_amount         |
| date_of_investment        |
+---------------------------+

+---------------------------+
|   investor_watchlist      |   <-- Investor saved startups
+---------------------------+
| id (PK)                   |
| investor_id (FK)          |
| startup_id (FK)           |
| added_on                  |
+---------------------------+

+---------------------------+
|   startup_favorites       |   <-- Startup saved favorite investors
+---------------------------+
| id (PK)                   |
| startup_id (FK)           |
| investor_id (FK)          |
| added_on                  |
+---------------------------+

+---------------------------+
|        interests          |   <-- Bi-directional user interest
+---------------------------+
| interest_id (PK)          |
| from_user_id (FK)         |
| to_user_id (FK)           |
| timestamp                 |
+---------------------------+
```

---

## Summary of Core Relationships

| Relationship                       | Description                                        |
| ---------------------------------- | -------------------------------------------------- |
| `users` → `startups` / `investors` | One-to-One per role                                |
| `startup_investor_map`             | Investors funding multiple startups and vice versa |
| `investor_watchlist`               | Investors save startups                            |
| `startup_favorites`                | Startups save investors                            |
| `interests`                        | Bi-directional interest stored once using user IDs |

---
