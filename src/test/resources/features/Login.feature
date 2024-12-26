@US2 @SR1
Feature: login to application
  As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

  Background: start page
    Given the user is on the login page

  Scenario: Users can login with valid credentials
    When the user provides a valid login username
    And the user provides a valid longin password
    And the user submits the longin credentials
    Then The user will be directed to the home page

   @SR3
    Scenario Outline: Users can not login with invalid credential
      When the user provides login username "<username input>"
      And the user provides login password "<password>"
      And the user submits the login credentials
      Then the user should get a browser login alert saying"<Invalid Credentials>"

Examples:
      |username |password         |allert                     |
      |Batman   |bOTs             |Invalid Credentials alert  |
      |Robin    |Iamthenight1939  |Invalid Credentials alert  |
      |Robin    |Bots             |Invalid Credentials alert  |

