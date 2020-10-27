# java-cucumber-apitest
Java Rest-assured Cucumber

# About
This is a basic testautomation framework built with: 
* Java
* Rest-assured
* Cucumber
* It addionally features: Abstract calls 

# Prerequisites
* Java, I use OpenJDK 15 
* Maven, I use 3.6.3
* Cucumber, Rest-assured, Junit, etc : see POM
* (optional) IntelliJ (2020 1 1 Community edition)
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
* Obviously, make more Call requests
* Add more API tests

# Remarks
* As there are no specs delivered with the Order-service, there are no defects, only remarks
  * Just this what struck me what was needed to make the feature file run: 
   * **I see order 1 with card "\"1\"" pass "\"10\"" status "\"CREATED\"" and amount 1001**
    * Yes, we need double quotes here ... :( 
