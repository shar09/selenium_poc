Feature: Test the welcome page functionality on TestProject Demo webpage

  Scenario Outline: The user should be able to save the form by entering correct details
    Given user is on the welcome page
    When user fills out form with correct data <country>, <address>, <email>, <phone>
    And user clicks on save
    Then form is saved

    Examples:
      | country | address | email | phone |
      | United States | North Street | testemail@example.com | 0123456789 |
      | Albania | South Street | cucumber@example.com | 98767889456 |
      | The Bahamas | Beach Street | selenium@example.com | 67687687886 |

  Scenario Outline: The user should not be able to save the form by entering incorrect details
    Given user is on the welcome page
    When user fills out form with incorrect data <country>, <address>, <email>, <phone>
    And user clicks on save
    Then form is not saved

    Examples:
      | country | address | email | phone |
      | United States | North Street | testemail | 0123456789 |
      |  | South Street | cucumber@example.com | 98767889456 |
      | The Bahamas |  | selenium@example.com | 67687687886 |
