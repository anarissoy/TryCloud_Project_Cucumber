Feature: As a user, I should be able to remove files from the favorites and upload a file directly
  User Story: As a user, I should be able to manage folders.


  @US7_TC1
  Scenario Outline: Verify users can add the folder
    Given user is on the login page
    When  user enters "<username>" and "<password>"
    When  the user clicks the Files module
    And   user click new folder
    And   user write a folder name
    When  the user click submit icon
    Then  Verify the folder is displayed on the page

    Examples:
      | username | password    |
      | user2    | Userpass123 |
#      | user32   | Userpass123 |
#      | user62   | Userpass123 |
#      | user92   | Userpass123 |

  @US7_TC2
  Scenario Outline: Verify users can upload a file inside a folder
    Given user is on the login page
    When user enters "<username>" and "<password>"
    When the user clicks the Files module
    And  user choose a folder from the page
    And  user clicks the add icon on the top
    When the user uploads a file with the upload file option
    Then Verify the file is displayed on the page

    Examples:
      | username | password    |
      | user2    | Userpass123 |
#      | user32   | Userpass123 |
#      | user62   | Userpass123 |
#      | user92   | Userpass123 |

