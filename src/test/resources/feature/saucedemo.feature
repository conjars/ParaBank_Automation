Feature: SauceDemo Shopping Flow

  Scenario: User logs in, selects a product, and completes checkout
    #Given I open the SauceDemo login page
    When I enter login credentials
      | username       | password      |
      | standard_user  | secret_sauce  |
    And I click on the login button
    And I handle any popup if present
    And I select filter option "Price (high to low)"
    And I add a product to the cart
    And I click on the cart icon
    #Then I verify the product in the cart
    And I proceed to checkout
    And I enter shipping details
    And I click on continue button
    Then I print the total price on the console
    And I complete the order
    Then I verify the order confirmation message "Thank you for your order!"
    And I return to the homepage
    And I logout from the application

    
    