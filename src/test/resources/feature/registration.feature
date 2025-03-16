#Feature: User Registration Functionality
#
#Scenario: User successfully registers with valid details
# Given User is on the registration page
#
#
Feature: User Registration and login

  #Scenario: Register a new user with login
    #Given user is on Parabank Page click on Register link under login button verify "Signing up is easy!" section is displayed
    #When user enter the below data to register
      #| FirstName  | LastName   | Address | City       | State      | ZipCode | Phone    | SSN        | Username | Password  | Confirm   |
      #| AutoTestFN | AutoTestLN | hyerbad | kukatpally | telanagana |  500055 | 73723232 | 3243423423 | RANDON | AutoTest1 | AutoTest1 |
  #Then user should navigate to home page verify "Accounts Overview" displayed, user clicks on logout button
  
  Scenario: User Registration with  login ui enter the data from excel
  
  Given user is on Parabank Page click on Register link under login button verify "Signing up is easy!" section is displayed
  When user enters details from Excel file "TestData_ParaBank.xlsx" with "UserDataSheet" and registers with a random username
  Then user should be redirected to the homepage store the registered username verify title as "Welcome"
  When user logs in with the stored username and password to home page verify "Accounts Overview" displayed, user clicks on logout button
  
  
  
  
  
  
  
 