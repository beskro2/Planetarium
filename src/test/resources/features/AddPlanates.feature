@US4
  Feature: Add Planet to planetarium
    As a user I want to add new planets and moons to the Planetarium so I can update my findings

    Background: start page
      Given the user is on the home page

  Scenario: User can add planets with valid data
      When the user provides a valid add planet name
      * And the user provides a valid planet file type
      And the user submits the add planet criteria
      Then a new planet is added

    @PR1 @PR2 @PR3 @PR6
    Scenario Outline:  User can not add new planets with invalid data
      When the user provides a add planet name <"planet name">
      * And the user provides a planet image  <"image">
      And the user submits the add planet criteria
      Then a user should get a add planet browser alert saying <"alert">


      Examples:
      |Planet Name                                             | Image  | Alert                                    |
      |                                                        |        |Browser Alert Message: Invalid Planet Name|
      | Molly tess tobu toff garthog lord of unholy darkness   |        |Browser Alert Message: Invalid Planet Name|
      | Molly$#@                                               |        |Browser Alert Message: Invalid Planet Name|
      | Molly_22                                               |        |Browser Alert Message: Invalid Planet Name|
      | Treader -2_2                                           |giff    |Browser  Alert Message: Invalid File Type |