Feature: leftnavigation functionality

  Background: 
    Given user loging into parabank page sucessfully verify home page as "Accounts Overview"

  #Scenario: verify all left navigationlinks in AccounServcie page
  #When user retives all navigation link
  #And user clicks on each link verifies the page
  Scenario: verify all left navigationlinks in AccounServcie page with DataTable // read the data from dataTable
    When user clicks on the following navigation links verifes the page name:
      | Link Name           | Expected PageName    |
      | Open New Account    | Open New Account     |
      | Accounts Overview   | Accounts Overview    |
      | Transfer Funds      | Transfer Funds       |
      | Bill Pay            | Bill Payment Service |
      | Find Transactions   | Find Transactions    |
      | Update Contact Info | Update Profile       |
      | Request Loan        | Apply for a Loan     |
      | Log Out             | Customer Login       |
