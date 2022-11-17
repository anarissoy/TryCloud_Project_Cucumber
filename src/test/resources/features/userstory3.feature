@smoke
Feature: As a user, I should be accessing all the main modules of the app.

#  @US3_1 @smoke
#  Scenario Outline: Verify users accessing all the main modules of the app.
#    Given user on the dashboard page
#    Then Verify the user see the following modules "<Modules>"
#
#    Examples:
#      | Modules   |
#      | Dashboard |
#      | Files     |
#      | Photos    |
#      | Activity  |
#      | Talk      |
#      | Contacts  |
#      | Circles   |
#      | Calendar  |
#      | Deck      |


  @us_03 @smoke
  Scenario Outline: As a user, I should be access all the main modules of the app.
    When user on the dashboard page by using "<username>" and "<password>"
    Then Verify the user see the following modules:
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |

  @multiLogin @smoke
    Examples:
      | username | password    |
      | user2    | Userpass123 |
#      | user32   | Userpass123 |
#      | user62   | Userpass123 |
#      | user92   | Userpass123 |