Feature: Buying products
  This feature will test the functionality concerning buying products online


  Background: The user is logged on
    When the user navigates to the logon page
    And the user logs on using his credentials
    Then the user should be logged on successfully


  Scenario Outline: Search a product and add it to the shopping cart
    Given the user navigates to the overview of <product>
    When the user adds the product to the cart
    Then the selected product should be added to the cart

    Examples:
    |product|
    |games   |
    |puzzles |


