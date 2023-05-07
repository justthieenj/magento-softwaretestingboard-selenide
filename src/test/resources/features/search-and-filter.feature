@search_filter
Feature: Search and filter products

  Background:

  @search
  Scenario: SE001 - The search result page should display correctly after searching with a keyword
    Given I input a keyword into Search box
    When I click Search button
    Then I should see items related to the search keyword in the search result
    Then The total item count should matches the actual total number of items displayed in all pages
    Then The related search terms are displayed

  @search
  Scenario: SE002 - The search result items are displayed as a list when clicking on the List button
    Given I input a keyword into Search box
    When I click Search button
    When I click the List button
    Then I see the search result items are displayed as a list

  @search
  Scenario: SE003 - The search result page should display correctly after clicking on a related search term
    Given I input a keyword into Search box
    When I click Search button
    When I click on a related search term
    Then I should see items related to the search keyword in the search result
    Then The total item count should matches the actual total number of items displayed in all pages
    Then The related search terms are displayed

  @search
  Scenario: SE004 - The most relevant product is displayed fist when search for a specific product name
    Given I navigate to homepage
    When I search with a specific product name: Neve Studio Dance Jacket
    Then I should see Neve Studio Dance Jacket displays fist in the search result


