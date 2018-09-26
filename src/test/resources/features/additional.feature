@run
Feature: Second Feature Global Search functionality

  Scenario Outline: Second Feature Search by product name
    Given Home page is opened
    When Set Super value "xxxxxxxxxxxxxxxxx"
    When Print Super value
    When Reprint Super value
    When Enter "<productName>" into Global Search field
    When Click on Show All button on Autosuggest list
    Then All descriptions of the products in Search results should contain "<productName>"
    Examples:
      | productName |
#      | ноутбук     |
      | стирал  |
#      | холодильник |

  Scenario: Repeated step of printing Super value
    When New Repeated step of printing Super value
    When Print Super value
    When Set Super value "zzzzzzzzzzzzzzzzzzzzzz"
    When Print Super value
