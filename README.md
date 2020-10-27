# java-cucumber-apitest
Java Selenium Cucumber

# About
This is a basic testautomation framework built with: 
* Java
* Selenium
* Cucumber
* It addionally features: Page objects and Page factory 

# Prerequisites
* Java, I use OpenJDK 15 
* Maven, I use 3.6.3
* Cucumber, Selenium, Junit, etc : see POM
* Optional IntelliJ (2020 1 1 Community edition)
* Git
* Order-service test app

# Installation
* Clone repo at: https://github.com/roncproject/java-cucumber-apitest 
* Install Order-service test app

# Usage
* Start the Order-service **BEFORE** every test run (otherwise the test sums in the features will not add up )
* Run the test with "mvn test"
* In the root of "java-cucumber-apitest", you will find a log file to make sense of the run

# TODO
* Obviously, make more GUI tests
* Add API tests

# Remarks
* As there are no specs delivered with the Order-service, there are no defects, only remarks
  * The navigation and functions of the app are confusing to me. 
    * When I create an order, I can [Confirm], but not confirming will also produce an order(!)
    * Cancelling will also produce an order (!!)
    * Even with confirming, I get back in the Order (status) screen, when I might want to go to the Order list(home page)
  * The input validation is not what I would expect given the category names ("Pass number, comma's, etc). These are dealt with in some of the test features
  * Misc.
    * I cannot, when using Test automation, make the [Back] button work, though it works manually.
    * Sometimes, an empty order list is shown, when the order database is actually filled. Could not recreate reliably
  
  
