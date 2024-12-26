@US4
  Feature: Add Planet to planetarium
    As a user I want to add new planets and moons to the Planetarium so I can update my findings

    Background: start page
      Given the user is on the home page
      And The Planet is selected

  Scenario: User can add planets with valid data
      When the user provides a valid add planet name
#      * And the user provides a valid planet file type
      And the user submits the add planet criteria
      Then a new planet is added

    @PR1 @PR2 @PR3 @PR6
    Scenario Outline:  User can not add new planets with invalid data
      When the user provides a add planet name "<planetName>"
#      * And the user provides a planet image  <"image">
      And the user submits the add planet criteria
      Then a user should get a add planet browser alert saying "<alert>"


      Examples:
      |PlanetName                                              | Image  | alert                                    |
      |                                                        |        | Invalid planet name|
      | Molly tess tobu toff garthog lord of unholy darkness   |        | Invalid planet name|
      | Molly$#@                                               |        | Invalid planet name|
      | Molly_22                                               |        | Invalid planet name|
#      | Treader -2_2                                           |giff    | Invalid File Type |