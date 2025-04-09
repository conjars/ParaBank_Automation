Feature: OpenCart Purchase Flow

@openCart
  Scenario: User adds a product to cart and proceeds to checkout
    Given User is on OpenCart login page
    When User logs in with valid credentials
    And User navigates to "Components" tab and selects "Monitors"    
    And user selects "25" from show dropdown, adds first product to cart, verifies specification, adds to wishlist, and sees success message
    And user searches for "HTC Touch HD", adds it to cart, updates quantity to "3", and clicks on update button
    And User verifies the items in the cart
   And User proceeds to checkout
   Then User successfully logs out
