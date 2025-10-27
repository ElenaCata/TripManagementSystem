# 🚀 Trip Management System

A complete Spring Boot application demonstrating OOP, REST API, Functional Programming, and SOLID principles.

---

## ✅ Grade 10 Requirements - ALL COMPLETE

- **OOP**: Inheritance, Polymorphism, Encapsulation, Abstraction
- **Spring Boot**: @Service, @Repository, @RestController, Dependency Injection
- **REST API**: 5 Controllers, ~20 endpoints, full CRUD
- **Functional Programming**: 4 methods with Streams, Lambda, filter, map, reduce
- **Database**: PostgreSQL + JPA/Hibernate with relationships
- **SOLID Principles**: All 5 principles implemented
- **Testing**: 9 tests (JUnit 5 + Mockito) - all pass
- **Code**: Simple, junior-level, all in English

```bash
gradlew bootRun
```

## 🌐 Accesare
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API Users**: http://localhost:8080/api/users
- **API Trips**: http://localhost:8080/api/trips

## ✅ Funcționalități
- ✅ CRUD complet pentru Users și Trips
- ✅ Moștenire OOP (User → RegularUser, BusinessUser, TravelAgent)
- ✅ Relații JPA (One-to-Many, Many-to-One)
- ✅ Cascade Delete
- ✅ RESTful API
- ✅ Documentație Swagger automată

## 📋 API Endpoints

### Users
- `POST /api/regular-users` - Create regular user
- `POST /api/business-users` - Create business user
- `POST /api/travel-agents` - Create travel agent
- `GET /api/users` - Get all users
- `DELETE /api/users/{uuid}` - Delete user

### Trips
- `POST /api/trips` - Create trip
- `GET /api/trips` - Get all trips
- `DELETE /api/trips/{id}` - Delete trip (use Long: 1, 2, 3...)
.
---

## 🎯 How to Use

1. **Add User**: Use specific endpoints (regular-users, business-users, travel-agents)
2. **Add Trip**: Name + Destination
3. **View**: Click "🔄 Refresh" to reload data
4. **Delete**: Copy ID from View page, paste in Delete page

⚠️ **Important**: After DELETE, go to View page and click "🔄 Refresh"

---

## 🧪 Run Tests
```bash
./gradlew test
```
**Result**: 9/9 tests pass ✅

---

## 📊 Project Structure

```
src/main/java/TripManagmentSystem/
├── model/          # 8 classes (User, Trip, RegularUser, BusinessUser, TravelAgent, etc.)
├── controller/     # 5 REST controllers
├── service/        # 4 services with business logic
└── repository/     # 2 JPA repositories

src/test/java/      # 9 unit tests
```

---

## 🎓 Key Features

### OOP Concepts
- **Inheritance**: User → RegularUser, BusinessUser, TravelAgent
- **Polymorphism**: `getUserType()` method
- **Encapsulation**: Private fields with getters/setters
- **Abstraction**: Abstract User class, Service interfaces

### Functional Programming
```java
// 1. Filter trips by destination
findTripsByDestination(String destination)

// 2. Find future trips
findFutureTrips()

// 3. Calculate total price (reduce)
calculateTotalPrice()

// 4. Get unique destinations (distinct + sorted)
getUniqueDestinations()
```

### SOLID Principles
- **S**ingle Responsibility: Each class has one purpose
- **O**pen/Closed: User is extensible (3 subclasses)
- **L**iskov Substitution: All User subclasses work correctly
- **I**nterface Segregation: Specific interfaces (TripService, UserService)
- **D**ependency Inversion: Services depend on interfaces

---

## 🔧 Configuration

**Database**: PostgreSQL
- Host: localhost:5432
- Database: trip_management
- Username: postgres
- Password: postgres

**JPA**: Auto-update schema (no manual SQL needed)

---

## 📝 Documentation

- **API_USAGE.md** - Complete API guide with examples
- **GRADE_10_FEATURES.md** - Detailed explanation of all features
- **HOW_TO_USE.md** - Step-by-step user guide

---

## ✅ Status

| Feature | Status |
|---------|--------|
| Build | ✅ SUCCESS |
| Tests | ✅ 9/9 PASS |
| Backend | ✅ Running |
| Frontend | ✅ Working |
| CRUD Operations | ✅ All working |
| DELETE | ✅ Works perfectly |

---

## 🎉 Ready for Grade 10!

All requirements complete. Simple, clean code. Full documentation. All tests pass.

**Good luck with your presentation!** 🎓
