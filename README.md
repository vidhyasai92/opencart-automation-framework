# OpenCart Automation Testing Framework

## 📋 Project Overview
This is a comprehensive Selenium-based test automation framework for the OpenCart e-commerce application. The framework follows the **Page Object Model (POM)** design pattern and implements industry best practices for maintainable and scalable test automation.

**Application Under Test:** [TutorialsNinja OpenCart Demo](https://tutorialsninja.com/demo/)

---

## 🏗️ Framework Architecture

### Design Pattern
- **Page Object Model (POM)** - Separates page elements and test logic for better maintainability
- **Data-Driven Testing** - Supports Excel-based test data management
- **Hybrid Framework** - Combines keyword-driven and data-driven approaches

### Key Components
```
Opencart100/
├── src/test/java/
│   ├── pageObjects/       # Page Object classes
│   ├── testBase/          # Base configuration and setup
│   ├── testCases/         # Test scenarios
│   └── utilities/         # Helper classes (Excel, Reports, Data Providers)
├── src/test/resources/
│   ├── config.properties  # Configuration file
│   └── log4j2.xml        # Logging configuration
├── testData/             # Excel test data files
├── screenshots/          # Test failure screenshots
├── logs/                 # Execution logs
├── reports/              # Extent Reports
└── test-output/          # TestNG reports
```

---

## ✨ Features

### Core Capabilities
- ✅ **Cross-Browser Testing** - Chrome, Firefox, Safari, Edge
- ✅ **Parallel Execution** - Run tests concurrently
- ✅ **Remote Execution** - Selenium Grid support
- ✅ **Data-Driven Testing** - Excel integration with Apache POI
- ✅ **Extent Reports** - Rich HTML test reports with screenshots
- ✅ **Log4j2 Logging** - Comprehensive execution logs
- ✅ **Screenshot on Failure** - Automatic capture for debugging
- ✅ **TestNG Integration** - Grouping, parameterization, listeners
- ✅ **Maven Build** - Dependency management and CI/CD ready

### Test Coverage
1. **User Registration** - Account creation with validation
2. **Login Functionality** - Valid/invalid credential testing
3. **Data-Driven Login** - Multiple user scenarios from Excel
4. **Product Search** - Search functionality validation
5. **Add to Cart** - Shopping cart operations

---

## 🛠️ Technology Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 11+ | Programming Language |
| Selenium WebDriver | 4.34.0 | Browser Automation |
| TestNG | 7.11.0 | Test Framework |
| Maven | 3.x | Build Tool |
| Apache POI | 5.4.1 | Excel Operations |
| ExtentReports | 5.1.2 | Reporting |
| Log4j2 | 2.24.3 | Logging |
| WebDriverManager | 5.9.2 | Driver Management |

---

## 📦 Prerequisites

### Required Software
- **Java JDK** 11 or higher
- **Maven** 3.6+
- **Eclipse IDE** (or any Java IDE)
- **Git** for version control

### Browser Drivers
Automatically managed by WebDriverManager - no manual setup required!

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/vidhya-web/opencart-automation-framework.git
cd opencart-automation-framework
```

### 2. Import into Eclipse
1. Open Eclipse IDE
2. File → Import → Existing Maven Projects
3. Browse to the cloned repository
4. Select the project and click Finish

### 3. Install Dependencies
```bash
mvn clean install
```

### 4. Configure Test Environment
Edit `src/test/resources/config.properties`:
```properties
execution_env=local
appURL=https://tutorialsninja.com/demo/
email=your-email@example.com
password=your-password
SearchProductName=iphone
```

---

## ▶️ Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Suite
```bash
mvn test -DsuiteXmlFile=master.xml
```

### Run from Eclipse
1. Right-click on `master.xml`
2. Run As → TestNG Suite

### Run Specific Groups
```bash
mvn test -Dgroups=Sanity
mvn test -Dgroups=Regression
```

### Cross-Browser Testing
```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
mvn test -Dbrowser=safari
```

---

## 📊 Test Reports

### Extent Reports
- Location: `reports/Test-Report-{timestamp}.html`
- Features: Screenshots, logs, test duration, pass/fail status
- Open in browser for interactive dashboard

### TestNG Reports
- Location: `test-output/index.html`
- Standard TestNG HTML reports

### Logs
- Location: `logs/automation.log`
- Detailed execution logs with Log4j2

---

## 🧪 Test Scenarios

### TC_001: Account Registration
- Navigate to registration page
- Fill registration form with random data
- Validate successful registration

### TC_002: Login Test
- Login with valid credentials
- Verify My Account page is displayed

### TC_003: Data-Driven Login
- Read test data from Excel
- Execute login with multiple datasets
- Validate expected results

### TC_004: Search Product
- Search for a product
- Verify search results

### TC_005: Add to Cart
- Search and add product to cart
- Verify cart contents

---

## 🔧 Configuration Files

### master.xml
Main TestNG suite file with:
- Browser and OS parameters
- Test class execution order
- ExtentReport listener configuration

### config.properties
Runtime configuration:
- Execution environment (local/remote)
- Application URL
- Test credentials
- Test data

### log4j2.xml
Logging configuration:
- Console and file appenders
- Log levels and patterns

---

## 📁 Page Objects

| Page Object | Description |
|-------------|-------------|
| BasePage | Constructor for driver initialization |
| HomePage | Landing page elements and actions |
| AccountRegPage | Registration form interactions |
| LoginPage | Login functionality |
| MyAccountPage | User account dashboard |
| SearchPage | Product search operations |
| ShoppingCartPage | Cart management |
| CheckOutPage | Checkout process |

---

## 🔄 CI/CD Integration

### Jenkins Pipeline
```groovy
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/vidhya-web/opencart-automation-framework.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Report') {
            steps {
                publishHTML([reportDir: 'reports', reportFiles: '*.html', reportName: 'Extent Report'])
            }
        }
    }
}
```

---

## 🐛 Troubleshooting

### Common Issues

**Issue:** Browser driver not found
- **Solution:** WebDriverManager handles this automatically. Ensure internet connectivity.

**Issue:** Tests fail on Safari
- **Solution:** Enable Remote Automation in Safari → Develop menu

**Issue:** Excel file not found
- **Solution:** Verify path in `testData/` folder

**Issue:** Screenshots not captured
- **Solution:** Check `screenshots/` folder permissions

---

## 📝 Best Practices Implemented

1. ✅ Page Object Model for maintainability
2. ✅ Explicit waits over implicit waits
3. ✅ Reusable utility methods
4. ✅ Proper exception handling
5. ✅ Meaningful test and method names
6. ✅ Comprehensive logging
7. ✅ Screenshot on test failure
8. ✅ Data-driven approach
9. ✅ Parallel execution support
10. ✅ Version control with Git

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📧 Contact

**Author:** Vidhyalakshmi Sambamurthy  
**Email:** vidhya.l.1604@gmail.com  
**GitHub:** [@vidhya-web](https://github.com/vidhya-web)

---

## 📄 License

This project is created for educational and portfolio purposes.

---

## 🎯 Future Enhancements

- [ ] API testing integration
- [ ] Database validation
- [ ] Docker containerization
- [ ] GitHub Actions CI/CD
- [ ] Allure reporting
- [ ] BDD with Cucumber
- [ ] Mobile testing support
- [ ] Performance testing integration

---

**⭐ If you find this project helpful, please give it a star!**
