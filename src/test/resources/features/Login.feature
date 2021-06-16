# Each feature file contains one feature

  Feature: Test the login functionality on TestProject Demo webpage

      # A feature file may have multiple scenarios

  Scenario: The user should be able to login with correct username and correct password
    Given user is on the login page
    When user enters correct username and correct password
    Then user should be redirected to welcome page

  Scenario Outline:  The user should not be able to login with correct username and wrong password
    Given user is on the login page
    When user enters correct <username> and wrong <password>
    Then user should receive password invalid error message

    Examples:
      | username | password |
      | John Doe | 909678   |
