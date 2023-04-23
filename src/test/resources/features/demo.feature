@demo
Feature: Demo

  Scenario: Data table example
    And I can see list of my orders
      | apple  |
      | mango  |
      | orange |
    But I dont have anything in this table
      | fruits | quantity |
      | apple  | 1        |
      | mango  | 2        |
      | orange | 6        |
    Then Data table XYZ without header
      | apple  | 1 |
      | mango  | 2 |
      | orange | 6 |

  Scenario Outline: Check if a word is palindrome
    Given I have a word <word>
    When I check if it is palindrome
    Then it should return <result>

    Examples:
      | word  | result |
      | Refer | true   |
      | Coin  | false  |