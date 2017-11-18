Feature: Cart Widget
  As a user
  I want to add items to my shopping cart
  So I can view and checkout these items

  Background:
    Given the user is signed in tom.acke@axxes.com Test1234

  @AddToCart
  Scenario Outline: Add and checkout items while signed in
    When the user adds <Amount> items size <Size> to the shopping cart <Item>
    And finishes the checkout procedure <Item> <Amount> <Size>
    Then he has bought the item

    Examples:
    |Item   |Amount|Size|
    |Blouse |4     |M   |
