@Content @oranum
Feature: Page content validation
  
  Validate that the contents on the page are unique and content is displyed as per selection

  #Background: 
    #Given the driver is invoked

  Scenario Outline: Validate that the contents is displyed as per the topic
    Given user is on the home page
    When user selects "<Topic>"
    Then content matching "<Topic>" is displayed
    And no duplicate content is displayed

    Examples: 
      | Topic        |
      | Love         |
      | Clairvoyance |
      | Tarot        |
      | Astrology    |
      | Dreams       |
      | Family       |
      | Career       |
      | Numerology   |
      | Pets         |
