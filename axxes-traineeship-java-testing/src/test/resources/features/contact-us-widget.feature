Feature: Contact Us Widget
  As a user
  I want to be able to contact the company through the site
  So I can submit questions and report issues

  Background:
    Given the user is on the contact us page

  @Example
  Scenario Outline: Send contact message
    When the user selects a subject heading <Heading>
    And the user fills out the email address <Email>
    And the user fills out the order reference <Reference>
    And the user fills out the contact message <Message>
    And the send button is clicked
    Then the message is successfully sent

    Examples:
    |Heading|Email|Reference|Message|
    |Customer service|tom.acke@axxes.com|951357|test content message|
