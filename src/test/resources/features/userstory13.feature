@US13 @smoke
Feature: US13 - As a user, I should be able to view the contact list.



  Scenario Outline: verify users can see all the contact names on the contact list
    Given user is on the login page
    When  user enters "<username>" and "<password>"
    And  the user clicks the "Contacts" module
    Then verify the contact names are in the list

    Examples:
      | username | password    |
      | user2    | Userpass123 |
#      | user32   | Userpass123 |
#      | user62   | Userpass123 |
#      | user92   | Userpass123 |




#13.Story: As a user, I should be able to view the contact list.
#
# Scenario: verify users can see all the contact names on the contact list
# Given user on the dashboard page
# When the user clicks the contacts module
# Then verify the contact names are in the list