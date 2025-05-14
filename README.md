# Selenium WebDriver with Java - Demo Project

This repository contains a demonstration project for web test automation using Selenium WebDriver with Java, developed as part of the Test Automation University course.

## About the Project

This project implements basic automated tests to demonstrate the knowledge acquired in the Selenium WebDriver with Java course. The tests include:

- Login to a web application
- Filling out forms
- Validation of page elements
- Handling alerts and windows
- Tests using Page Objects Pattern

## Technologies Used

- Java 
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager

## Project Structure

```
.
├── src/
│   ├── main/java/
│   │   └── com/selenium/demo/
│   │       ├── pages/
│   │       │   ├── HomePage.java
│   │       │   ├── LoginPage.java
│   │       │   └── FormPage.java
│   │       └── utils/
│   │           └── DriverFactory.java
│   └── test/java/
│       └── com/selenium/demo/
│           ├── LoginTest.java
│           ├── FormTest.java
│           └── AlertTest.java
├── pom.xml
└── README.md
```

## How to Run the Tests

1. Clone this repository:
```
git clone https://github.com/thiagohvo/WebDriver-TAU.git
```

2. Navigate to the project directory:
```
cd WebDriver-TAU
```

3. Run the tests with Maven:
```
mvn clean test
```

## Test Cases Implemented

- **LoginTest**: Verifies the login process with valid and invalid credentials
- **FormTest**: Tests the filling out and submission of forms
- **AlertTest**: Demonstrates how to handle different types of alerts in the browser

## Learning Resources

- [Test Automation University](https://testautomationu.applitools.com/)
- [Selenium Documentation](https://www.selenium.dev/documentation/en/)
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)

## Contribution

Feel free to contribute to this project. All contributions are welcome!

1. Fork the project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request
