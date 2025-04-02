Feature: OpenCart Purchase Flow

@openCart
  Scenario: User adds a product to cart and proceeds to checkout
    Given User is on OpenCart login page
    When User logs in with valid credentials
    And User navigates to "Components" tab and selects "Monitors"
    And User selects the first product and adds it to the cart
    And User searches for "HTC Touch HD" and adds it to cart
    And User verifies the items in the cart
   And User proceeds to checkout
   Then User successfully logs out
