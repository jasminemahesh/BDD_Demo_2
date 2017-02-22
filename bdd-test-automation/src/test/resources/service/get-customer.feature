Feature: Retrieve Customer details

 Scenario: Get Customer By valid Customer Id
    When Get the Customer Details for Account Id 1
    Then Customer Details for Account Id 1 is retrieved
    
 Scenario: Get Customer By invalid Customer Id
    When Get the Customer Details for Account Id 9999
    Then Service Throws Error 500
    
  Scenario: Get list of all Customer
    When Get List of All Customers
    Then Get list of customers receives status code of 200