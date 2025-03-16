Feature: Automate Button Operations on HerokuApp

  Scenario: Perform three button operations
    #Given I navigate to "https://the-internet.herokuapp.com/"
    When I click on "Add/Remove Elements"
    And I add an element
    And I delete an element
    And I navigate back
    And I click on "Checkboxes"
    And I select a checkbox
    And I navigate back
    And I click on "Dropdown"
    And I select "Option 2" from the dropdown
    Then I verify "Option 2" is selected
