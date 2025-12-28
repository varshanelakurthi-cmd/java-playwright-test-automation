## Overview

This project is a Playwright automation framework built using Java, designed to test web applications with scalable, maintainable, and CI-ready architecture.
It follows industry best practices including Page Object Model, retry mechanisms, reporting, and CI/CD integration.


### Tech Stack
* Java 17
* Playwright (Java)
* TestNG 
* Maven
* Allure Reports

### GitHub Actions (CI/CD)
Framework Design
* Page Object Model (POM) for clean separation of test logic
* BaseTest to manage browser lifecycle
* Retry Mechanism to handle flaky tests
* Parallel Execution using TestNG
* Headless execution for CI environments
* Allure Reports for test visibility

### Project Structure

src
└── test
├── java
│   ├── base        → BaseTest (browser setup/teardown)
│   ├── pages       → Page Object classes
│   ├── tests       → TestNG test classes
│   ├── listeners   → Retry & TestNG listeners
│   └── utils       → Utilities (RetryAnalyzer)
└── resources
└── testng.xml  → Parallel execution config

.github
└── workflows
└── automation.yml → CI pipeline


### Run Tests Locally
1.	Clone the repository
      git clone https://github.com/varshanelakurthi-cmd/java-playwright-test-automation.git
      cd java-playwright-test-automation

2.  Run tests
    mvn test


### Parallel Execution

Parallel execution is enabled using TestNG.

Run tests in parallel using:

mvn test -DsuiteXmlFile=testng.xml

### Allure Reporting

Generate & View Report
allure serve target/allure-results

The report provides:
* Test summary
* Pass/Fail trends
* Execution time
* Failure details

### Retry Mechanism

Flaky tests are automatically retried using TestNG RetryAnalyzer implemented via Listeners, ensuring:
* Reduced false negatives
* Stable CI execution

### CI/CD Integration (GitHub Actions)
* Tests run automatically on every push to master
* Executed on Ubuntu Linux
* Playwright browser dependencies installed dynamically
* Headless execution for CI

CI workflow file:

.github/workflows/automation.yml

### Test Application

Tests are executed against a public demo application:

https://www.saucedemo.com

### Key Learnings & Highlights
* Designed CI-safe Playwright framework
* Debugged Linux CI environment issues
* Implemented retry logic using listeners
* Integrated reporting & parallel execution
* Hands-on GitHub Actions experience

### Author
Automation Engineer Candidate
GitHub:
https://github.com/varshanelakurthi-cmd

### Why This Project Matters

This framework demonstrates real-world automation engineering skills, including:
* Framework design
* CI/CD integration
* Debugging environment-specific issues
* Scalable test execution