Feature: Typing text
  Scenario: User can read and type text
    Given User opens page
    And User clicks on textarea
    When User reads text sign by sign
    Then Text is entered