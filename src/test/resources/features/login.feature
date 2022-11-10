Feature:

  Background:
    Given user on the login page

  @login
  Scenario:
    #Given user on the login page
    When user use username and password and login
    Then verify the user should be at the dashboard page

  @multipleLogin
  Scenario Outline:
    When user use "<username>" and "<password>" and login
    Then verify the user should be at the dashboard page

    Examples:
      | username | password    |
      | user2    | Userpass123 |
      | user32   | Userpass123 |
      | user62   | Userpass123 |
      | user92   | Userpass123 |

