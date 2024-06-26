Feature: User Login

  Scenario: Successful Login
    Given the user is on nopCommerce login page
    When the user enter valid credentials(username: "rohinipvkumar19@gmail.com",password: "Test@123")
    And the user clicks on Login button
    Then the user should be redirected to My Account Page
    And the user should see welcome message
    
