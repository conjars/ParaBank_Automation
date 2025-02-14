#Feature: User Registration Functionality
#
#Scenario: User successfully registers with valid details
# Given User is on the registration page
#
#
Feature: User Registration and login

  Scenario: Register a new user with login
    Given user is on Parabank Page click on Register link under login button verify "Signing up is easy!" section is displayed
    When user enter the below data to register
      | FirstName  | LastName   | Address | City       | State      | ZipCode | Phone    | SSN        | Username | Password  | Confirm   |
      | AutoTestFN | AutoTestLN | hyerbad | kukatpally | telanagana |  500055 | 73723232 | 3243423423 | RANDON | AutoTest1 | AutoTest1 |
  Then user should navigate to home page verify "Accounts Overview" displayed, user clicks on logout button
  