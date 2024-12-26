@US4
  Feature: Add Moon to planetarium
    As a user I want to add new planets and moons to the Planetarium so I can update my findings

    Background: start page
      Given the user is on the home page
      And The Moon is selected

    Scenario: User can add moons with valid data
        When User provides a valid add moon name
        And user provides a valid associated planet
#        * And the user provides a moon picture
        And the user submits the add moon criteria
        Then the user should view the Moon from the home page

    @MR1 @MR2 @MR3 @MR4 @MR7
    Scenario Outline:User can not add new moons with invalid data
      When the user provides add moon name "<moonname>"
      And the user provides associatedPlanet "<associatedPlanet>"
#      And the user provides a moon picture "<Image>"
      And the user submits the add moon criteria
      Then the user should get a add moon browser alert saying "<alert>"
#*? for the moon pic mabe solution is two scenerio outlines one with the image and one without
      Examples:
      | moonname                                    | associatedPlanet         | Image | alert                                        |
      | gandalffrodosamlegolisegimliborimirearigorn | frodo                    |       |  Browser Alert Message: Invalid Moon Name    |
      |                                             | frodo                    |       |  Browser Alert Message: Invalid Moon Name    |
      | Saurumon#@!                                 | frodo                    |       |  Browser Alert Message: Invalid Moon Name    |
      | uruk                                        | frodo                    |       |  Browser Alert Message: Invalid Moon Name    |
      | Sam Wise_22-                                | ThisPlanateDoesnotExcist |       |  Browser Alert Message: Invalid Planet ID    |
      | Sam Wise_22-                                |                          |       |  Browser Alert Message: Invalid Planet ID    |
      | Sam Wise_22-                                | Frodo                    | giff  |  Browser Alert Message: Invalid File Type    |

