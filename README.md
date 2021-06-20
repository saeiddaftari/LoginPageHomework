# LoginPageHomework
## Table of Contents
* [Introduction](#introduction)
* [Technologies](#technologies)
## Introduction
The project is considering several test cases of newsletter subscription in the scenario's login page using Selenium WebDriver
## Technologies
Project is created with:
* Java 16.0.1
* Selenium server standalone 3.141.59
* Maven 4.0.0
* JUnit 4
* Cucumber 6.10.4
* Gherkin 15.0.2
* Mockito 1.10.19
## Scenarios
#### Subscription Test:
It's the simplest scenario, I just test it with a correct email address to make it easy to read and execute, but in other scenarios I used different browsers and also because I'm using "WebDriverManager" the project is compatible with different operating systems.
#### Wrong Emails:
As you can guess from the title, I tested some incorrect email addresses to find out the behaviour of this login page, and as you can see the error note appears in red.
I made a cross browser test with Chrome, Firefox and Edge webdrivers.
#### Confirm Subscription:
This is extended version of Subscription Test, for testing this scenario I used a temporary email web page, every step shows the expected results, except the final step that driver redirected to a different url than "https://www.hoeffner.de/nl-anmeldung".
#### Duplicate Email:
I want to verify if it is possible to subscribe with an email address that subscribed successfully before or not, it is under construction, but you can see the steps in feature file.
#### Unsubscribe:
The other test case that we should execute is the possibility of unsubscription.
