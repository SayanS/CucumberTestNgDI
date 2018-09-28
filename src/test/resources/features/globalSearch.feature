@ignore
Feature: Global Search functionality
  Background:
    Given Home page is opened

  Scenario Outline: Check that all Products description in Search results contains Searching text
    When Enter "<productName>" into Global Search field
    When Click on Show All button on Autosuggest list
    Then All descriptions of the products in Search results should contain "<productName>"
    Examples:
      | productName |
      | фен         |
      | ноутбук     |
      | стирал  |


