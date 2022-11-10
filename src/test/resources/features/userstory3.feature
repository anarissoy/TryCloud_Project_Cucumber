Feature: As a user, I should be accessing all the main modules of the app.

  @US3
  Scenario Outline: Verify users accessing all the main modules of the app.
    Given user on the dashboard page
    Then Verify the user see the following modules "<Modules>"

    Examples:
      | Modules   |
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |


  @us_03
  Scenario: As a user, I should be access all the main modules of the app.
    When user on the dashboard page
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