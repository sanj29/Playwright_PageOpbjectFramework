# Playwright Page Object Framework 🎭🧪

A **Playwright Java-based UI automation framework** built using the **Page Object Model (POM)** design pattern and integrated with **GitHub Actions CI** for automated execution.

This repository demonstrates how to build a **production-ready, CI-stable, and maintainable** UI automation framework suitable for real-world enterprise projects.

---

## 🚀 Why Playwright + Page Object Model

The **Page Object Model (POM)** helps:

* Separate test logic from UI interactions
* Improve readability and maintainability
* Reduce duplication when UI changes
* Scale automation for large applications

**Playwright** adds:

* Fast and reliable execution
* Auto-waiting and resilient locators
* Cross-browser support (Chromium, Firefox, WebKit)
* First-class CI compatibility

---

## 🧩 Tech Stack

* **Language:** Java (JDK 11+)
* **Test Framework:** TestNG
* **Automation Tool:** Playwright for Java
* **Build Tool:** Maven
* **CI/CD:** GitHub Actions
* **Design Pattern:** Page Object Model (POM)

---

## 🗂️ Project Structure

```
Playwright_PageOpbjectFramework/
│
├── src/
│ ├── main/java/
│ │ ├── pages/ # Page Object classes
│ │ └── utils/ # Utilities & helpers
│ │
│ └── test/java/
│ ├── base/ # BaseTest & lifecycle setup
│ ├── factory/ # PlaywrightFactory & ThreadLocal manager
│ └── tests/ # Test classes
│
├── .github/workflows/ # GitHub Actions CI workflow
├── pom.xml # Maven configuration
├── testng.xml # TestNG parallel execution config
└── README.md
```

---

## ⚙️ Prerequisites

Make sure the following are installed locally:

* Java JDK 11 or higher
* Maven
* Git

---

## 📦 Setup & Installation

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/sanj29/Playwright_PageOpbjectFramework.git
cd Playwright_PageOpbjectFramework
```

### 2️⃣ Install Dependencies

```bash
mvn clean install -DskipTests
```

### 3️⃣ Install Playwright Browsers

```bash
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

---

## ▶️ Running Tests Locally

### Run all tests (headless)

```bash
mvn test
```

### Run tests in headed mode

```bash
mvn test -Dheadless=false
```

Headless execution is enabled by default for CI stability.

---

## 🔀 Parallel Test Execution
Parallel execution is enabled using TestNG.
Configuration is defined in testng.xml:

```
<suite name="Playwright Parallel Suite"
       parallel="methods"
       thread-count="3">

    <test name="UI Tests">
        <packages>
            <package name="com.playwright.automation.tests"/>
        </packages>
    </test>
</suite>
```
Benefits
✔ Faster execution
✔ Better CI resource utilization
✔ Scalable automation runs

## 🧵 Thread-Safe Playwright Design
This framework uses ThreadLocal to ensure:
* Each test runs in its own browser context
* No shared browser or page state
* Safe and deterministic parallel execution
This design prevents flaky tests and browser collisions in CI.

## 🧪 BaseTest Design (CI-Safe)

* Browser and page are created **per test method**
* Ensures full test isolation
* Prevents flaky behavior in CI

Key principles:

* No shared browser state
* Defensive setup and teardown
* Optional UI actions (e.g., cookie banners)

---

## 🤖 CI/CD Integration (GitHub Actions)

This project is integrated with **GitHub Actions** to automatically:

* Build the project
* Install Playwright browsers
* Install Linux system dependencies
* Execute tests in headless mode

### CI Trigger Events

* Push to `main`
* Pull Request to `main`
* Manual trigger (`workflow_dispatch`)

### CI Environment

* **OS:** Ubuntu 22.04 (pinned for Playwright stability)
* **Java:** Temurin JDK 11
* **Execution Mode:** Headless

CI configuration lives in:

```
.github/workflows/playwright-java.yml
```

---

## ✅ Best Practices Implemented

* Page Object Model (POM)
* CI-friendly headless execution
* OS-pinned CI runner for stability
* Defensive UI handling (optional elements)
* Clean test lifecycle management

---

## 🚀 Possible Enhancements

Future improvements you can add:

* Parallel execution using ThreadLocal
* Allure or HTML reporting
* Screenshots and traces on failure
* Browser matrix execution
* Environment-based execution (QA / STG / PROD)

---

## 🤝 Contributing

Contributions and suggestions are welcome.
Feel free to fork the repository and raise a pull request.

---

## 👤 Author

**Sanjay Singh**
Staff Software QA Engineer | Automation | Playwright | CI/CD | AI Enthusiast

---

⭐ If this repository helps you, consider giving it a star!
