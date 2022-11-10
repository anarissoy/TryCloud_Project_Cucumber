Feature: As a user, I should be able to access to Files module.

  @US4_TC1
  Scenario: verify users can access to Files module
    Given user on the dashboard page
    When the user clicks the "Files" module
    Then verify the page title is "Files - Trycloud QA"

  @US4_TC2
  Scenario: verify users can select all the uploaded files from the page
    Given user on the dashboard page
    When the user clicks the "Files" module
    And user click the top-left checkbox of the table
    Then verify all the files are selected


#Story: As a user, I should be able to access to Files module.
#Feature: As a user, I should be able to access to Files module.
# Scenario: verify users can access to Files module
#Given user on the dashboard page
#When the user clicks the "Files" module
#Then verify the page title is "Files - Trycloud QA.”

# Scenario: verify users can select all the uploaded files from the page
#Given user on the dashboard page
#When the user clicks the "Files" module
#And user click the top-left checkbox of the table
#Then verify all the files are selected