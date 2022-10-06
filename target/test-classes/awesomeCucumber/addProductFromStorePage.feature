Feature: Add product from Home page

  Rule: rule 1

      Scenario: Add a Blue Shoes to cart
        Given I am in Store page
        When I add a "Blue Shoes" to cart
        Then 1 "Blue Shoes" is shown in my cart

