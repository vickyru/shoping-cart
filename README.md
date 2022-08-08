
# Shopping Cart

This is framework is created for the demo purpose only


## Features

- Page Object Model
- Cross Browser Support (Chrome & Firefox)
- Zalenium
- Azure release pipeline


## Tech Specs
- Java 11
- Selenium v4.1.3
- Testng v6.3
- Extent Reporter v2.12.0
- Apache log4j v2.17.2
## Installation

Install shopping cart

Clone repo
```git
git clone git@github.com:vickyru/shoping-cart.git 
```
Navigate to project folder

```bash
  mvn install
```

## Running Tests

### To start tests, run the following command
- In QA environment

```bash
  mvn clean install -Denv="qa"
```

- In DEV environment

```bash
  mvn clean install -Denv="dev"
```

- In staging environment

```bash
  mvn clean install -Denv="stage"
```
- In UAT environment

```bash
  mvn clean install -Denv="uat"
```

- In production environment

```bash
  mvn clean install -Denv="prod"
```
- Single test with browser & testing environment 

```bash
  mvn clean install -Dtest=LoginPageTest -Dbrowser=firefox -Dbrowserversion=91.10
```

## Report
Extent report is getting generated in build folders