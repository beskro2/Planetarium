  @US5 @SR2
  Feature: User Planet Deletion
    As a user I want to remove planets and moons from the Planetarium so I can correct my findings

    Background: start page
      Given the user is on the home page
      And  The Planet is selected

      Scenario: User can Delete their Planet with their credentials
        When the user provides a valid delete planet name
        And the user submits the delete planet criteria
        Then the planet will be deleted from the homepage

      @PR1 @PR4 @SR2
      Scenario Outline: User can not Delete planet with invalid credentials
        When the user provides a delete planet name "<name>"
        And the user submits the delete planet criteria
        Then the user should get a delete planet browser alert saying "<alert>"

        Examples:
        |name        |alert                                     |
        |                   |Invalid planet name|
        |notaplanet         |Invalid planet name|
        |Someoneelsesplanet |Invalid planet name|