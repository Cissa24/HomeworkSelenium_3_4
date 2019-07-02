Feature: Complete Shopping Flow
  As a user I want to be able to complete whole process of shopping, from selecting the item to completion of transaction

  Background: User is logged in
    Given User is logged in

  Scenario: Adding an item to the cart

    Given user navigates to Women Department and selects a listing item
    When user adds it to the shopping cart
    And user verifies billing address
    And user verifies delivery address
    And user clicks on proceed to checkout button
    And user checks agreement disclosure
    And user clicks on proceed to checkout on Agreement page
    And user selects check as a payment method
    And user confirms order
    And user verifies the price
    Then user verifies that order was successfully submitted
    And user goes back to orders
    And verifies that placed order is in order history

