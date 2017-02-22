Feature: Create Account
     
    Scenario: Create Account with valid user details
    When Create Account for user
    | Daniel | Smith | Male | 0034-3233333112 | daniels@gmail.com | SP2334452  | Barcelona | Barcelona | 54566 | United States  | Current | 15000 |
    Then An Account for "Daniel" "Smith" is created
    
    Scenario: Create Account with valid user details
    When Create Account for user
    | Elsa | Cruz | Female | 0034-32366552222 | elsacruz@gmail.com | SP23888  | Carlington Street | Copenhagen | 54566 | Denmark  | Savings | 20000 |
    Then An Account for "Elsa" "Cruz" is created
    
    Scenario: Create Account with invalid user details : firstname and lastname can not be 1 cahracter
    When Create Account for user
    | D | S | Male | 0034-3233333112 | daniels@gmail.com | SP2334452  | Barcelona | Barcelona | 54566 | United States  | Current | 15000 |
    Then Service throws error 400
    
    Scenario: Create Account with invalid user details : invalid email id
    When Create Account for user
    | Daniel | Smith | Male | 0034-3233333112 | danielsgmail.com | SP2334452  | Barcelona | Barcelona | 54566 | United States  | Current | 15000 |
    Then Service throws error 400
    
    Scenario: Create Account with invalid user details : null address and null Postal Code
    When Create Account for user
    | Daniel | Smith | Male | 0034-3233333112 | danielsgmail.com | SP2334452  | | Barcelona | | United States  | Current | 15000 |
    Then Service throws error 400
    
    
     Scenario: Create Account with invalid user details : null address and null Postal Code
    When Create Account for user
    | Daniel | Smith | Male | 0034-3233333112 | danielsgmail.com | SP2334452  | | Barcelona | | United States  | Current | 15000 |
    Then Service throws error 400

    
    