
Feature: Test facebook smoke scenario

  Scenario: Login with valid credentials
    Given Open browser and start application
    When I enter valid "yas@gmail.com" and valid "password"
    Then user should be able to login successfully
    
