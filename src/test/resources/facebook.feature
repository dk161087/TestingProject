@F1
Feature: Validating login functionality of facebook application

  @smoke
  Scenario: Validating login with valid username and invalid password
    Given User is on FB page
    When User enter valid username and invalid password
    And User click on login button
    Then User validate home page

  @sanity
  Scenario: Validating login with invalid username and valid password
    Given User is on FB page
    When User enter invalid username and valid password
    And User click on login button
    Then User validate home page

  @reg
  Scenario: Validating login with invalid username and invalid password
    Given User is on FB page
    When User enter invalid username and invalid password
    And User click on login button
    Then User validate home page

  @E2E
  Scenario: Validating login with valid username and valid password
    Given User is on FB page
    When User enter valid username and valid password
    And User click on login button
    Then User validate home page
