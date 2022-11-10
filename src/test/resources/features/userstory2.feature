
Feature: As a user, I should be able to login to TryCloud app


  @US2
  Scenario Outline: verify user login fail with invalid credentials "<username>"
    Given user on the login page
    When user enters "<username>" and "<password>"
    Then "<message>" message should be displayed

    Examples:
      | username | password    | message                     |
      | User2    | Wrong       | Wrong username or password. |
      | Wrong    | Userpass123 | Wrong username or password. |
      | Wrong    | Wrong       | Wrong username or password. |
