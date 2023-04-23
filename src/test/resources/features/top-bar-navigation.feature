@top-bar-navigation
Feature: Top bar navigation

  Background:

  Scenario Outline: NAV001 - The correct page should display when I navigate to a category on the top bar
    Given I go to the home page
    When I navigate to <category> on the top bar
    Then I should see the <page> page display with correct <title> title

    Examples:
      | category             | page                                                                         | title   |
      | Women->Tops->Jackets | https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html | Jackets |
      | Women->Tops->Tees    | https://magento.softwaretestingboard.com/women/tops-women/tees-women.html    | Tees    |
      | Gear->Bags           | https://magento.softwaretestingboard.com/gear/bags.html                      | Bags    |
