#Author: mail.jatint@gmail.com	

Feature: Verify the login functionality of Flipkart website

@LoginTest
Scenario: Verify the login functionality is working as expected
    Given The user has navigated to the Flipkart home Page 
    And The user clicks on the Login link
    When The user enters the "<credentials>"
    And The user clicks on the login button
    Then The login should be "<result>"
    
    Examples: 
      | credentials  | result |
      | bWFpbC5qYXRpbnRAZ21haWwuY29tOkpANzFuVGhhY2tlcg== | successful |
      | bWFpbC5qYXRpbnRAZ21haWwuY29tOkpANzFuVGhhY2s= | successful |
