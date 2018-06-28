Feature: Sign in
  This feature will test the functionality concerning signing in


  Scenario: The user is logged on
    When the user navigates to the logon page
    And the user logs on using his credentials
    Then the user should be logged on successfully