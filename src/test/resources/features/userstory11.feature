@US11 @smoke
Feature: US11 - As a user, I should be able to access to Talks module

  @US11_TC1
  Scenario Outline: Verify users update settings
    Given user is on the login page
    When  user enters "<username>" and "<password>"
    And  the user clicks the Talk module
    Then verify the page title is "Talk - Trycloud"

    Examples:
      | username | password    |
      | user2    | Userpass123 |
#      | user32   | Userpass123 |
#      | user62   | Userpass123 |
#      | user92   | Userpass123 |

  # TC1 BUG report


  @US11_TC2
  Scenario Outline: verify users to send a message
    Given user is on the login page
    When  user enters "<username>" and "<password>"
    And  the user clicks the Talk module
    And user search user from the search box
    And user write a message
    And user clicks to submit button
    Then the user should be able to see the message is displayed on the conversation log

    Examples:
      | username | password    |
      | user2    | Userpass123 |
#      | user32   | Userpass123 |
#      | user62   | Userpass123 |
#      | user92   | Userpass123 |




#11. Story: As a user, I should be able to access to Talks module.
#Feature: As a user, I should be able to access to Talks module
# Scenario: verify users to access to Talks module
# Given user on the dashboard page
# When the user clicks the "Talk" module
# Then verify the page title is "Talk - Trycloud QA"

# Scenario: verify users to send a message
# Given user on the dashboard page
# When the user clicks the "Talk" module
# And user search user from the search box
# And user write a message
# And user clicks to submit button
# Then the user should be able to see the message is displayed on the conversation log