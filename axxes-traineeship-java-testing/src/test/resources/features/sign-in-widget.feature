Feature: Sign in Widget
  As a user
  I want to be able to sign in to the site
  So I can place orders and view my profile details

  Background:
    Given the user is on the sign up page

  @Example
  Scenario: Sign in as existing user
    When I enter a valid email address tom.acke@axxes.com
    And I enter a valid password Test1234
    And I click the submit button
    Then I am signed in to the application