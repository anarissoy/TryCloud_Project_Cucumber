@US10 @smoke
Feature: US10 - Story: As a user, I should be able to update settings.

  @US10_TC1
  Scenario Outline: Verify users update settings
    Given user is on the login page
    When  user enters "<username>" and "<password>"
    And  the user clicks the "Files" module
    And user clicks Settings on the left bottom corner
    Then the user should be able to click any buttons


    Examples:
      | username | password    |
      | user2    | Userpass123 |
#      | user32   | Userpass123 |
#      | user62   | Userpass123 |
#      | user92   | Userpass123 |


  @US10_TC2
  Scenario Outline: Verify users to see the app storage usage
    Given user is on the login page
    When  user enters "<username>" and "<password>"
    And  the user clicks the "Files" module
    And user checks the current storage usage
    And user uploads file with the upload file option
    And user refresh the page
    Then the user should be able to see storage usage is increased


    Examples:
      | username | password    |
      | user2    | Userpass123 |
#      | user32   | Userpass123 |
#      | user62   | Userpass123 |
#      | user92   | Userpass123 |





#10.Story: As a user, I should be able to update settings.
# Scenario: Verify users update settings
# Given user on the dashboard page
# When the user clicks the "Files" module
# And user clicks Settings on the left bottom corner
# Then the user should be able to click any buttons


# Scenario: Verify users to see the app storage usage
# Given user on the dashboard page
# When the user clicks the "Files" module
# And user checks the current storage usage
# And user uploads file with the upload file option
# And user refresh the page
# Then the user should be able to see storage usage is increased