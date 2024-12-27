@US4
  Feature: Add Moon to planetarium
    As a user I want to add new planets and moons to the Planetarium so I can update my findings

    Background: start page
      Given the user is on the home page
      And The Moon is selected

    Scenario: User can add moons with valid data
        When User provides a valid add moon name
        And user provides a valid associated planet
        And the user provides a moon picture
        And the user submits the add moon criteria
        Then the user should view the Moon from the home page

    @MR1 @MR2 @MR3 @MR4 @MR7
    Scenario Outline:User can not add new moons with invalid data
      When the user provides add moon name "<moonname>"
      And the user provides associatedPlanet "<associatedPlanet>"
      And the user submits the add moon criteria
      Then the user should get a add moon browser alert saying "<alert>"
#*? for the moon pic mabe solution is two scenerio outlines one with the image and one without
      Examples:
      | moonname                                    | associatedPlanet         | Image | alert                |
      | gandalffrodosamlegolisegimliborimirearigorn | 1                        |       | Invalid moon name    |
      |                                             | 1                        |       | Invalid moon name    |
      | Saurumon#@!                                 | 1                        |       | Invalid moon name    |
      | Luna                                        | 1                        |       | Invalid moon name    |
      | Luna                                        | 2                        |       | Invalid moon name    |
      | Sam Wise_22-                                | 3000000                  |       | Invalid planet id    |
      | Sam Wise_22-                                |                          |       | Invalid planet id    |
#

    @MR1 @MR2 @MR3 @MR4 @MR7
    Scenario Outline:User can not add new moons with invalid image data
      When the user provides add moon name "<moonname>"
      And the user provides associatedPlanet "<associatedPlanet>"
      And the user provides a moon picture "<Image>"
      And the user submits the add moon criteria
      Then the user should get a add moon browser alert saying "<alert>"

      Examples:
        | moonname                                    | associatedPlanet         | Image                                                                                                 | alert               |
        |Sam Wise_22-                                 | 1                        | C:\Users\eskro\OneDrive\Desktop\Testing project 1\Planetarium_Project\dscovrepicmoontransitfull.webp  | Invalid File Type    |
        |Sam Wise_22-                                 | 1                        | C:\Users\eskro\OneDrive\Desktop\Testing project 1\Planetarium_Project\dscovrepicmoontransitfull.webp  | Invalid File Type    |
