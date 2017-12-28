Feature: Contact Us Widget
  As a user
  I want to be able to contact the company through the site
  So I can submit questions and report issues

  Background:
    Given the user is on the contact us page

  @Regression @ContactForm
  Scenario: Send contact message
    When the user selects a subject heading
    And the user fills out the email address
    And the user fills out the order reference
    And the user fills out the contact message
    And the send button is clicked
    Then the message is successfully sent

