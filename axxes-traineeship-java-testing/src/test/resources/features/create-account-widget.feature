Feature: Create account widget
  As a user
  I want to create a new account
  So i can order clothing online

  Background:
    Given the user is on the sign up page
    And navigates to the create account page

  @Regression @CreateAccount
  Scenario: Create a new account
    When the user enters all required personal information fields:
      |User|Axxes|Test1234|Test street 220 Box 5|Seatle|Washington|12345|United States|012345678|Test|
    And clicks on the register button
    Then the new account is created
