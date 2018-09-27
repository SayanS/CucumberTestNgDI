@run
Feature: Second Feature Global Search functionality

  Scenario Outline: Second Feature Search by product name
    Given Home page is opened
    When Enter "<productName>" into Global Search field
    When Click on Show All button on Autosuggest list
    Then All descriptions of the products in Search results should contain "<productName>"
    Examples:
      | productName |
#      | ноутбук     |
      | стирал  |
#      | холодильник |

