@search_filter
Feature: Search and filter products

  Background:

  @search
  Scenario: SE001 - The search result page should display no item when search with an invalid keyword
    Given I navigate to homepage
    When I search with an invalid keyword: abcs
    Then I should see the search result return no item

  @search
  Scenario: SE002 - The search result items are displayed as a list when clicking on the List button
    Given I navigate to homepage
    When I search with a valid keyword: women's top
    When I click the List button
    Then I see the search result items are displayed as a list

  @search
  Scenario: SE003 - The search result items are sorted by price when i select option "Price" at Sort By box
    Given I navigate to homepage
    When I search with a valid keyword: women's top
    When I select option "Price" at Sort By box
    Then The search result items are sorted by price

  @search
  Scenario: SE004 - The most relevant product is displayed fist when search for a specific product name
    Given I navigate to homepage
    When I search with a specific product name: Neve Studio Dance Jacket
    Then I should see Neve Studio Dance Jacket displays fist in the search result


