# OpenCart Automation Framework

Selenium-based test automation framework for OpenCart e-commerce application using Page Object Model design pattern.

## Tech Stack

- Java 11
- Selenium WebDriver 4.34.0
- TestNG 7.11.0
- Maven
- ExtentReports 5.1.2
- Log4j2

## Project Structure

```
src/test/java/
├── pageObjects/     # Page Object classes
├── testBase/        # Base test configuration
├── testCases/       # Test scenarios
└── utilities/       # Helper classes
```

## Setup

### Prerequisites
- JDK 11 or higher
- Maven 3.6+

### Installation

```bash
git clone https://github.com/vidhyasai92/opencart-automation-framework.git
cd opencart-automation-framework
mvn clean install
```

## Running Tests

```bash
# Run all tests
mvn test

# Run specific test suite
mvn test -DsuiteXmlFile=master.xml

# Run with specific browser
mvn test -Dbrowser=chrome
```

## Configuration

Update `src/test/resources/config.properties`:

```properties
execution_env=local
appURL=https://tutorialsninja.com/demo/
email=your-email@example.com
password=your-password
```

## Features

- Page Object Model design pattern
- Cross-browser testing (Chrome, Firefox, Safari, Edge)
- Data-driven testing with Excel
- ExtentReports for test reporting
- Log4j2 for logging
- TestNG for test management
- Parallel execution support
- Selenium Grid support

## CI/CD

GitHub Actions workflow runs tests automatically on every push.

## Docker Support

```bash
# Run with Docker Compose (Selenium Grid)
docker-compose up -d
mvn test -Dexecution_env=remote
docker-compose down
```

## Reports

- ExtentReports: `reports/Test-Report-{timestamp}.html`
- TestNG Reports: `test-output/index.html`
- Logs: `logs/automation.log`

## Test Scenarios

1. User Registration
2. User Login
3. Product Search
4. Add to Cart
5. Data-Driven Login Tests

## Author

Vidhyalakshmi Sambamurthy

## License

This project is for educational and portfolio purposes.
