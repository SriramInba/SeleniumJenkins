
@tag
Feature: Purchase the order from Website
  Order the product from website
	Background: 
	Given Land on Ecommerce page

  @Regression
  Scenario Outline: Positive Scenario
    Given Login with username <name> and password <pwd>
    When I add the product ZARA to cart
    And Checkout ZARA and submit
    Then Verify the order confirmation and message displayed 'THANKYOU FOR THE ORDER.'

    Examples: 
      | name  | pwd	| 
      | sriraminba03@gmail.com | Test@123	|  
      
