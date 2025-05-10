Feature: OrangeHRM End-to-End Testing
  As an OrangeHRM user
  I want to perform key actions in the system
  So that I can validate the core functionalities
  
  Background:  
  Given the user is logged into the OrangeHRM application
@ORangeHrm
  Scenario: Login to OrangeHRM
    Given the user is on the OrangeHRM login page
    When the user enters username "Admin" and password "admin123"
    And clicks on the login button
    Then the user should be redirected to the Dashboard page
@ORangeHrmleft
  Scenario: Verify and print left-side menu links
    Given the user is logged into the OrangeHRM application
    When the user prints all menu links
    Then the system should display the total number of menu links
@ORangeempStatus
  Scenario: Search for an employee by employment status
    Given the user is on the Employee List page under PIM
    When the user selects "Full-Time Contract" from the Employment Status dropdown
    And clicks on the search button
    Then the employee list should be filtered accordingly
    Then the user should be logged out successfully

  #Scenario: Logout from multiple tabs
    #Given the user is on the OrangeHRM Dashboard page
    #When the user right-clicks the Dashboard link and opens it in a new tab
    #And logs out from the new tab
    #And switches back to the main tab and logs out again
    #Then the user should be logged out successfully
