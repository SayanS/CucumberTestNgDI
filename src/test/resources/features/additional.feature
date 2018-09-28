@run
Feature: Checking additional functionality
  Background:
    Given Home page is opened

  Scenario: Second Feature Search by product name
    When Enter "Ноутбук" into Global Search field
    When Click on Show All button on Autosuggest list
#    When Click on Global Search button of Autosuggest field in Header
    When Add to cart first product from Search results

