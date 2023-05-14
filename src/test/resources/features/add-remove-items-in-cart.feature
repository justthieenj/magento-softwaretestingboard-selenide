Feature: Add/Remove items in shopping cart

  Background:
    Given I navigate to homepage

  @add_item
  Scenario: CART001 - I can add an item into shopping cart from a product category page after select size and color
    Given I search with a specific product name: Jupiter All-Weather Trainer
    When I select size S and color Blue for the product
    When I add the product to cart
    When I wait until product is added to cart
    When I click on the Shopping Cart icon
    Then I should see the product is added into shopping cart as the top most item
    Then I should see the product details matches with what I selected

  @add_item
  Scenario: CART002 - I can't add an item into shopping cart from a product category if I don't select size and color
    Given I search with a specific product name: Olivia 1/4 Zip Light Jacket
    When I add the product to cart
    Then I should be navigated to the product details page
    Then I should see a warning message: You need to choose options for your item.

#  @add_item
#  Scenario: CART003 - I can add an item into shopping cart from a product details page if select size and color
#    Given I search with a specific product name: Jupiter All-Weather Trainer
#    When I click Add to Cart button
#    When I select size and color for the product: S+Blue
#    When I click Add to Cart button
#    When I click on the Shopping Cart icon
#    Then I should see the product is added into shopping cart as the top most item
#    Then I should see the product details matches with what I selected
#    Then I should see the Items In Cart and Cart Subtotal number updated
#
#  @add_item
#  Scenario: CART004 - I can't add an item into shopping cart from a product details page if don't select size and color
#    Given I search with a specific product name: Jupiter All-Weather Trainer
#    When I click Add to Cart button on the product
#    When I click Add to Cart button on the product details page
#    Then I should see warning messages at Size and Color field: This is a required field.
#
#  @remove_item
#  Scenario: CART005 - I can remove an item from the shopping cart dropdown
#    Given I add an item to the shopping cart
#    When I click on the Shopping Cart icon
#    When I click on the Remove icon of the newly added item
#    When I click OK
#    When I click on the Shopping Cart icon
#    Then I should see the product is removed from shopping cart
#    Then I should see the Items In Cart and Cart Subtotal number updated
#
#  @remove_item
#  Scenario: CART006 - I can remove an item from the shopping cart page
#    Given I add an item to the shopping cart
#    When I click on the Shopping Cart icon
#    When I click on the View and Edit Cart button
#    When I click on the Remove icon of the newly added item
#    Then I should see the product is removed from shopping cart
#    Then I should see the Items In Cart and Cart Subtotal number updated
#
#  @remove_item
#  Scenario: CART007 - I can move an item to Wishlist from the shopping cart page
#    Given I add an item to the shopping cart
#    When I click on the Shopping Cart icon
#    When I click on the View and Edit Cart button
#    When I click on the Move to Wishlist button of the newly added item
#    Then I should see the product is removed from shopping cart
#    Then I should see the Items In Cart and Cart Subtotal number updated
