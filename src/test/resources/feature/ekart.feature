Feature: Cart Functionality

  Scenario: Add an item to the cart and validate in the web table
    Given User navigates to the home page
    When User adds "Samsung galaxy s6" to the cart
    And User navigates to the cart page
    Then The item "Samsung galaxy s6" should be present in the cart web table

  Scenario: Remove an item from the cart and handle alert popup
    Given User adds "Samsung galaxy s6" to the cart
    And User navigates to the cart page
    When User removes the item from the cart
    Then The cart should be empty


  Scenario: Place an order and handle multiple windows
    Given User adds "Samsung galaxy s6" to the cart
    And User navigates to the cart page
    When User clicks on "Place Order"
    And User enters order details and completes the purchase
    Then Order confirmation should be displayed
 


  Scenario: Verify advertisement iframe
    Given User navigates to the home page
    When User switches to the advertisement iframe
    Then Advertisement banner should be visible
    
    
    

  Scenario: Logout and verify alert popup
    Given User is logged in
    When User clicks logout
    Then Alert popup should be displayed
    And User should be redirected to login page
    