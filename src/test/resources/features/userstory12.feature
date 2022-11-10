Feature: As a user, I should be able to access to Contacts module.

  @US12
  Scenario Outline: verify user access to Contacts module
    Given user is on the login page
    When  user enters "<username>" and "<password>"
    When the user clicks the "Contacts" module
    Then verify the page title is "Contacts - Trycloud QA"

    Examples:
      | username | password    |
      | user2    | Userpass123 |
#      | user32   | Userpass123 |
#      | user62   | Userpass123 |
#      | user92   | Userpass123 |

  # BUG REPORT


#12.Story: As a user, I should be able to access to Contacts module.
#Feature: As a user, I should be able to access to Contacts module.
#  Scenario:  verify user access to Contacts module
#    Given user on the dashboard page
#    When the user clicks the "Contacts" module
#    Then verify the page title is "Contacts - Trycloud QA"