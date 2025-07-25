# 📘 My Favorite Quotes App

An Android application built with **Kotlin**, using **RecyclerView** and **MVVM architecture**, that allows users to add, view, delete, and refresh a list of their favorite quotes. The data is stored locally using **SharedPreferences** (no database like Room is used).

---

## 🚀 Features

- ➕ Add new quotes (with author)
- 👆 Click to view quote in a toast
- ✋ Long click to delete a quote
- 🔄 Pull to refresh (automatically reloads list)
- 📦 Persistent storage using SharedPreferences
- 💡 MVVM Architecture
- 🧾 JSON serialization with Gson
- 💳 Stylish CardView UI

---

## 🏗️ Architecture

MVVM
│
├── model → Data classes
├── viewmodel → ViewModel with LiveData
├── view → Activities, RecyclerView Adapter
├── repository → Handles data operations
└── utils → SharedPreferences helper with Gson

---

## 🛠️ Tech Stack

- **Kotlin**
- **RecyclerView**
- **MVVM Architecture**
- **SharedPreferences**
- **Gson**
- **CardView**
- **LiveData & ViewModel**
- **Material Design Components**

---

## 📷 Screenshots

| Main Screen | Add Dialog |
|-------------|------------|
| ![Main](screenshot_main.png) | ![Dialog](screenshot_dialog.png) |

> *(You can add actual screenshots after running the app)*

---

## 🧪 How to Run

1. Clone or download this repository.
2. Open it in **Android Studio**.
3. Run the app on a real or virtual device.
4. Add quotes, tap them, long press to delete!

---

## ✅ Requirements

- Android Studio Hedgehog or later
- Android SDK 21+
- Internet not required (fully offline app)

---

## 🤝 License

This project is free to use in educational or personal projects.

---

## 👨‍🏫 Perfect For

- Android beginners
- Kotlin learners
- Teaching MVVM without Room
- Practicing RecyclerView full features