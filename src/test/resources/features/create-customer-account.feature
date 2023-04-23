@customer_account
Feature: Create customer account
  Create customer account using unique email address
  Description...

  Background:
    Given I click on Create Account link

  @negative @empty_first_name
  Scenario: Create customer account fail: Empty first name
    When I try to create a customer account with empty first name
    Then Show error message that first name is required

  @negative
  Scenario: Create customer account fail: Empty last name
    When I try to create a customer account with empty last name
    Then Show error message that last name is required

  @positive
  Scenario: Create customer account successfully
    When I try to create a customer account with valid information
    Then I created a customer account successfully
