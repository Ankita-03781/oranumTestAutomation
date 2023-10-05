@Signup @oranum
Feature: Signup Overlay
  
  Verify Signup Overlay is displayed on clicking buttons

  Scenario Outline: Verify Signup Overlay is displayed on clicking buttons
    Given user is on the live chat page
    When user clicks on below "<buttons>"
    Then buttons will trigger a 'sign up' overlay to be displayed

    Examples: 
      | buttons          |
      | Get Credits      |
      | Add to favorites |
      | Surprise         |
      | Start Session    |
