# Playwright Page Object Framework 🎭🧪

A **Playwright-based UI automation framework** built using the **Page Object Model (POM)** design pattern. This repository demonstrates how to structure scalable, maintainable, and readable end-to-end tests for modern web applications using Playwright.

This project is ideal for QA engineers, SDETs, and automation leads who want a clean reference implementation of Playwright with POM.

---

## 🚀 Why Page Object Model with Playwright

The **Page Object Model (POM)** helps:

* Separate test logic from UI interactions
* Reduce code duplication
* Improve maintainability when UI changes
* Make tests more readable and reusable

Playwright complements POM with fast execution, auto-waiting, and reliable selectors.

---

## 🗂️ Project Structure

```
Playwright_PageOpbjectFramework/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/        # Page Object classes
│   │       └── utils/        # Utilities (browser setup, config, helpers)
│   │
│   └── test/
│       └── java/
│           └── tests/        # Test classes
│
├── pom.xml                   # Maven dependencies & build config
├── .gitignore
└── README.md
```

---

## 🛠️ Prerequisites

Ensure the following are installed on your system:

* Java JDK 11 or higher
* Maven
* Any IDE (IntelliJ IDEA / VS Code recommended)

---

## 📦 Setup & Installation

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/sanj29/Playwright_PageOpbjectFramework.git
cd Playwright_PageOpbjectFramework
```

### 2️⃣ Install Dependencies

```bash
mvn clean install
```

### 3️⃣ Install Playwright Browsers

```bash
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

---

## 📘 Page Object Example

```java
public class LoginPage {
    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String username, String password) {
        page.locator("#username").fill(username);
        page.locator("#password").fill(password);
        page.locator("button:has-text('Login')").click();
    }
}
```

✔ Page classes contain **only locators and actions**
✔ No assertions inside page objects

---

## 🧪 Test Example

```java
@Test
public void validLoginTest() {
    LoginPage loginPage = new LoginPage(page);
    loginPage.login("admin", "password");
    // Assertions go here
}
```

Tests focus on **business flows**, not UI details.

---

## ▶️ Running Tests

Run all tests using Maven:

```bash
mvn test
```

Playwright supports **parallel execution** out of the box, making test runs fast and efficient.

---

## ✅ Best Practices Followed

* Page Object Model (POM)
* Clear separation of concerns
* Reusable page actions
* Stable Playwright locators
* Clean project structure

---

## 🚀 Possible Enhancements

You can extend this framework by adding:

* CI/CD using GitHub Actions
* Test reporting (Allure / HTML reports)
* Data-driven testing
* Cross-browser execution
* API or backend validation

---

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome.
Feel free to fork the repo and raise a pull request.

---

## 👤 Author

**Sanjay Singh**
Staff Software QA Engineer | Automation | Playwright | AI Enthusiast

---

⭐ If this repository helps you, consider giving it a star!
