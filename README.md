
# Selenium Automation Boilerplate

## Overview

This project provides a boilerplate for setting up Selenium tests with support for various browsers, including Chrome, Firefox, Edge, Safari, and BrowserStack integration.

## Prerequisites

- Java JDK 8 or higher
- Maven
- BrowserStack account (if using BrowserStack)

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/clim-bot/selenium-automation-boilerplate.git
    ```

2. Navigate into the project directory:

    ```bash
    cd selenium-automation-boilerplate
    ```

3. Install dependencies:

    ```bash
    mvn clean install
    ```

## Running Tests

### Running All Tests

```bash
mvn test
```

### Running Specific Suite

To run tests in Chrome only:

```bash
mvn test -DsuiteXmlFile=src/test/testng-chrome.xml
```

## Configuration

### BrowserStack

Set up the following environment variables for BrowserStack:

```bash
export BROWSERSTACK_USERNAME=your_username
export BROWSERSTACK_ACCESS_KEY=your_access_key
```

### Browsers

Update the `testng.xml` file to specify the browser to run the tests on.

## Continuous Integration

### GitHub Actions

This project includes a GitHub Actions workflow to run tests on demand.

### Dependabot

Dependabot is configured to check for dependency updates regularly.

## License

This project is licensed under the MIT License.
