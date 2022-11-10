Feature: As a user, I should be able to access to Files module - Favorites button
User Story: As a user, I should be able to add file to favorites.

  @US5
  Scenario Outline: Verify users to add files to Favorites
    Given user is on the login page
    When user enters "<username>" and "<password>"
    And the user clicks the Files module
    And the users click action-icon from any file on the page
    And user choose the Add to favorites option
    And user click the Favorites sub-module on the left side
    Then Verify the chosen file is listed on the table

    Examples:
      | username | password    |
      | user2    | Userpass123 |
#      | user32   | Userpass123 |
#      | user62   | Userpass123 |
#      | user92   | Userpass123 |


