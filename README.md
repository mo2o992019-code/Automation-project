# Amazon Website Test Automation
> This is a test automation task on [Amazon Website ](https://www.amazon.eg/?language=en_AE) website (The automation validates **login**, **product search**, **add-to-cart**, and **cart validation** using **Selenium + TestNG**.)


## Installation

Clone the repo:


https://github.com/mo2o992019-code/Automation-project.git


Install dependencies:

You need to install these dependencies from [mvnrepository](https://mvnrepository.com/):

sh
Selenium WebDriver
TestNG
WebDriverManager
JSON Simple

Requires:
sh
JDK 17
Maven


## Test Scenarios

Scenario 1 – Login

1- Open Amazon page: https://www.amazon.eg/?language=en_AE

2- Click on Sign in

3- Enter a valid email

4- Verify the message:
“We cannot find an account with that email address” (if the account doesn’t exist)

Scenario 2 – Product Search & Add to Cart

1- Click on Today’s Deals

2- Search for a product in the search bar

3- Click Search

4- Click on the product picture

5- Add 1 more product (so total in cart = 2)

6- Open Cart

7- Validate price & quantity

## Skills

- Java
- Selenium WebDriver
- TestNG
- POM (Page Object Model)
- Data-driven testing (JSON)
- Maven
