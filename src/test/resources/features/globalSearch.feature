Feature: Global Search functionality


  Scenario Outline: Test experiments
    Given Home page is opened
    Given User credentials
      | login | password |
      | John  | qwerty   |
    When Change user "email" to unique value
    Then Enter "<product name>" into Global Search field
    Examples:
      | product name |
      | телевизор    |


  Scenario: Check that first product name from the Autosuggest list equal to Search product
    Given Home page is opened
#    Given Click on "Да" button of Select city pop-up
    When Enter "Телевизор TOSHIBA 49U7750EV" into Global Search field
    Then First item of the Autosuggest list of the Header Search should be
      | imgLink                                              | productName                 | oldPrice | price    |
      | https://i.eldorado.ua//55x55//goods/5477/5477164.jpg | Телевизор TOSHIBA 49U7750EV |          | 16999 .- |

  Scenario: Check that all Products description in Search results contains Searching text
    Given Home page is opened
#    Given Click on "Да" button of Select city pop-up
    When Enter "телевизор" into Global Search field
    When Click on Show All button on Autosuggest list
    Then All descriptions of the products in Search results should contain "телевизор"


  Scenario Outline: Check Search city
    Given Home page is opened
#    When Click on "Нет" button of Select city pop-up
    When Enter "<text>" into City name field on Select city pop-up
    Then Each context city on Select city pop-up should start with "<text>"
    Examples:
      | text    |
      | П       |
      | Харьков |

  @ignore
  Scenario: Check ability to select default city
    Given Home page is opened
#    When Click on "Нет" button of Select city pop-up
    When Select city "Харьков" on Select city pop-up
    Then Selected city "Харьков" should be displayed in Header menu
    Then Notification message "Город изменен на Харьков" should be displayed



