# 🍶 Sake Shops App

This is a mobile application built as part of a technical assessment for a Mobile Developer (Android) position. The app displays a list of local sake shops and provides detailed information about each shop, such as address, rating, image, and website.

---

## 📱 Features

- Display a list of sake shops (name, address, rating)
- Navigate to a detail screen for each shop
- Detail screen includes:
  - Shop name
  - Description
  - Image (if available)
  - Star rating
  - Clickable address (opens Google Maps)
  - Link to the shop’s website (opens in browser)

---

## 🧠 Architecture

The app follows **Clean Architecture** and the **MVVM** pattern, using modern Android development tools:

com.leandro.sakeshop
- data // DTOs, local data source, repository implementation
- domain // Business logic: models, use cases, repository interface
- presentation // UI with Jetpack Compose, ViewModels, Navigation
- core // Dependency Injection (Hilt), utility classes


---

## 🧰 Tech Stack

- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Gson](https://github.com/google/gson) – for JSON parsing
- [Coil](https://coil-kt.github.io/coil/) – for image loading
- [Navigation-Compose](https://developer.android.com/jetpack/compose/navigation)
- [Material 3](https://m3.material.io/) – theming and UI components

---

## 🧪 Testing

- Includes a unit test for the use case `GetSakeShopsUseCase`
- Test tools: `JUnit`, `Mockito Kotlin`, `kotlinx.coroutines-test`

---

## 🗂️ How to Run the Project

1. Clone this repository
2. Open in Android Studio (Hedgehog or newer)
3. Make sure you have an emulator or device running Android 8+
4. Run the app using the green ▶ Run button

> The app reads static data from a local file: `assets/sakeshop.json`

---

## 📁 Data Source

All the sake shop data is loaded from a local JSON file located at:

app/src/main/assets/sakeshop.json

---

## ✅ Potential Improvements (If Given More Time)

- Add pull-to-refresh
- Add search and filters
- Implement pagination for large lists
- Handle errors and loading states gracefully
- UI tests with Espresso / Compose Test
- Mark favorite shops (local persistence)
- Support dark mode

---

## 👨‍💻 Author

**Leandro Bastos**  
GitHub: [github.com/17bastos](https://github.com/17bastos)  
Email: hello@leandrobastos.dev

---

## 📄 License

This project is for evaluation purposes only.
