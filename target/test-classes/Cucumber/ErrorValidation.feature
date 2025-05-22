
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @Errorcheck
  Scenario Outline: Incorrect Creds
    Given Land on Ecommerce page
    When Login with username <name> and password <pwd>
    Then "Incorrect email or password." Popup display

     Examples: 
      | name  | pwd	| 
      | sriraminba04@gmail.com | Test@123	|  