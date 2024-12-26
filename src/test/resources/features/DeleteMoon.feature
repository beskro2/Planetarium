  @US5
  Feature: User Moon Deletion
    As a user I want to remove planets and moons from the Planetarium so I can correct my findings

    Background: start page
      Given the user is on the home page

      Scenario: user can delete their moon with valid credentials
        When the user provides a valid delete moon name
        And the user submits the delete moon criteria
        Then the moon will be deleted from the homepage

        @MR1 @MR4 @SR2
        Scenario Outline: User can not delete moon with invalid credentials
          When the user provides a delete moon name "<name>"
          And the user submits the delete moon criteria
          Then the user should get a delete moon browser alert saying "<alert>"

          Examples:
          |name            |alert             |
          |                |Invalid moon name |
          |notamoon        |Invalid moon name |
          |Someoneelsesmoon|Invalid moon name |