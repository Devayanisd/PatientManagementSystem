Feature: OrangeHRM Login Functionality

  As a user
  I want to login into OrangeHRM application
  So that I can access the dashboard


  @ValidLogin
  Scenario: Login with valid credentials
    Given the user opens the browser
    When the user navigate to the login page
    And the user type the username "Admin"
    And the user type the password "admin123"
    And user clicks on login button
    Then the user should navigate to the Dashboard page
    
    @InvalidLogin
    Scenario Outline: Login with Invalid Credentials
    Given the users opens the browser
    When the user navigate to the login page
    And the user enters the username "<username>"
    And the user enters the password "<password>"
    And user clicks on login button
    Then the users should see error message
    
    Examples:
    | username | password |
    | admin123 | 12345    |
    | user123  | admin    |
    | Adminuser| user124  |