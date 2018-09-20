Feature: Second Feature Global Search functionality

  Scenario Outline: Second Feature Search by product name
    Given Home page is opened
    Given User credentials
      | login | password |
      | John  | qwerty   |
    When Change user "email" to unique value
    Then Enter "<product name>" into Global Search field
    Examples:
      | product name |
      | телевизор    |
