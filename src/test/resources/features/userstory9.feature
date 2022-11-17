@US9
Feature: As a user, I should be able to write comments to files/folders.


  Scenario Outline: Verify users can add the folder
    Given user is on the login page
    When  user enters "<username>" and "<password>"
    And  the user clicks the "Files" module
    And   user click action-icon from any file on the page
    And   the user choose the "Details" option
    And  user write a comment inside the input box
    And user click the submit button to post it
    Then  Verify the comment is displayed in the comment section.

    Examples:
      | username | password    |
      | user2    | Userpass123 |
#      | user32   | Userpass123 |
#      | user62   | Userpass123 |
#      | user92   | Userpass123 |




#9. Story: As a user, I should be able to write comments to files/folders.
#Feature: As a user, I should be able to write comments to files/folders.
# Scenario: Verify users to write comments to files/folder
# Given user on the dashboard page
# When the user clicks the "Files" module
#And user click action-icon from any file on the page
# And user choose the "Details" option
# And user write a comment inside the input box
#And user click the submit button to post it
# Then Verify the comment is displayed in the comment section.