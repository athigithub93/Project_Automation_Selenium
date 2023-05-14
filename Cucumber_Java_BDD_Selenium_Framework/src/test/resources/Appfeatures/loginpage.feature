Feature: login functionality for Amazon E-Commerce Website
  
  As a user of the Amazon website
  I want to be able to log in with my account
  So that I can access my account-related features and manage my orders

  Background: 
    Given : User is on the login page

  Scenario: Login page title
    When : User gets the title of the page
    Then : Page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"

  Scenario: Successful login with valid credentials
    Given user clicks on the HelloBtn
    Given User enter a valid username
    And User clicks on the continue button
    And User enter a valid password
    When User click on the login button
    Then User should be logged in successfully

 
  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given User entered invalid "<username>" and "<password>"
    When User click on the login button
    Then User should see an error message indicating "error_message"

    Examples: 
      | username          | password        | error_message       |
      | invalid@email.com | invalidpassword | There was a problem |
      | abccc             | validpassword   | There was a problem |
