@run
Feature: Global Search functionality

  Scenario Outline: Check that all Products description in Search results contains Searching text
    Given Home page is opened
    When Enter "<productName>" into Global Search field
    When Click on Show All button on Autosuggest list
    Then All descriptions of the products in Search results should contain "<productName>"
    Examples:
      | productName |
      | фен         |


