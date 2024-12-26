@US4
  Feature: Add Moon to planetarium
    As a user I want to add new planets and moons to the Planetarium so I can update my findings

    Background: start page
      Given the user is on the home page

      Scenario:
        When User provides a valid add moon name
        And user provides a valid planet ID
        * And the user provides a moon picture
        And the user submits the add moon criteria
        Then the user should view the Moon from the home page

    @MR1 @MR2 @MR3 @MR4 @MR7
    Scenario Outline:
      When the user provides add moon name <"moon name">
      And the user provides planetID <"planetID">
      * And the user provides a moon picture<"picture">
      And the user submits the add moon criteria
      Then the user should get a add moon browser alert saying "<alert>"

      Examples:
      | Moon Name                                   | Planate Name             | Image | alert                                        |
      | gandalffrodosamlegolisegimliborimirearigorn | frodo                    |       |  Browser Alert Message: Invalid Moon Name    |
      |                                             | frodo                    |       |  Browser Alert Message: Invalid Moon Name    |
      | Saurumon#@!                                 | frodo                    |       |  Browser Alert Message: Invalid Moon Name    |
      | uruk                                        | frodo                    |       |  Browser Alert Message: Invalid Moon Name    |
      | Sam Wise_22-                                | ThisPlanateDoesnotExcist |       |  Browser Alert Message: Invalid Planet ID    |
      | Sam Wise_22-                                |                          |       |  Browser Alert Message: Invalid Planet ID    |
      | Sam Wise_22-                                | Frodo                    | giff  |  Browser Alert Message: Invalid File Type    |

