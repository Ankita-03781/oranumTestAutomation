@Search @oranum
Feature: Search Capability
  
  Verify search functionality

  Scenario Outline: Perform search operation
    Given user is on the oranum home page
    When user clicks on search box
    And searches a "<name>"
    Then all results should contain "<name>"

    Examples: 
      | name |
      | Matt |
      | Myst |
      | Ann  |
      | psy  |
