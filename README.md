# JavaFX POS Desktop Application

A desktop-based Point of Sale (POS) system built with **JavaFX**, **SQLite**, and **MVC architecture**. The application supports:

- ✅ Role-based access (admin, employee)
- 🛍️ Product listing and management
- 📝 Customer and order tracking

## ✨ Features

- 🔒 **Secure Login** using `BCrypt` hashing
- 🛍️ **Product Management** (add, view products)
- 📝 **Order Tracking** with itemized details
- 📧 **Customer Database** with email storage
- 🔄 **Navigation Stack** to support back-button across views
- 💾 **SQLite-backed storage** using JDBC
- 🎨 **Built with JavaFX (FXML-based UI)**

## 📁 Project Structure
src/
├── com.example/
│ ├── HelloApplication.java # Main launcher
│ ├── controller/ # JavaFX controllers
│ ├── model/ # Java data models (Product, Order, etc.)
│ ├── util/
│ │ ├── DatabaseHelper.java # SQLite + JDBC logic
│ │ ├── DatabaseSeeder.java # Seeds the DB
│ │ └── NavigationManager.java # Handles view transitions
│ └── resources/
│ ├── *.fxml # JavaFX views


## 📜 Requirements
- ✅ Java 17+ (Java 21 or OpenJDK 24 recommended)
- ✅ JavaFX SDK (version matching your runtime)
