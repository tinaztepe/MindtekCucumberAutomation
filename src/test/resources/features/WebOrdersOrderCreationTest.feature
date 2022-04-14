@OMT-7929
Feature: Validating calculate and order creation functionalities

  Scenario Outline: Validating calculate functionality
    Given user navigates to the weborders application
    When user provides username "Tester" and password "test"
    And user navigates to Order module
    And user selects "<product>" product with <quantity>
    Then user validates total is calculated properly for quantity <quantity>

    Examples:
      | product     | quantity |
      | MyMoney     | 1        |
      | FamilyAlbum | 100      |
      | ScreenSaver | 55       |
      | MyMoney     | 20       |

  @OMT-7931
  Scenario Outline: validating create order functionality
    Given user navigates to the weborders application
    When user provides username "Tester" and password "test"
    And user counts number of orders in table
    And user navigates to Order module
    And user creates order with data
      | product   | quantity   | name   | street   | city   | state   | zip   | cc   | expire date   |
      | <product> | <quantity> | <name> | <street> | <city> | <state> | <zip> | <cc> | <expire date> |
    Then user validates success message "New order has been successfully added."
      ##And user validates order added to List of Orders
    Examples:
      | product     | quantity | name             | street      | city    | state | zip   | cc               | expire date |
      | MyMoney     | 10       | John Doe         | 123 My Road | Chicago | IL    | 12345 | 1234567890987654 | 12/22       |
      | FamilyAlbum | 5        | John Patel Harsh | 124 My Road | Chicago | IL    | 12345 | 1234567890981234 | 07/22       |
      | ScreenSaver | 1        | Kim Yan          | 125 My Road | Chicago | IL    | 12345 | 1234567890983456 | 03/22        |







