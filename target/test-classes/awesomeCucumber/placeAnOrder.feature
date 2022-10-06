Feature: Place an order

  Rule: rule 1

    Scenario: Add a Blue Shoes to cart
      Given I am a guest customer
#        | firstname  | lastname  | email             |
#        | First Name | Last Name | myEmail@gmail.com |
      And I have a product in cart
      And I'm on Checkout page
      When I provide billing address
        | firstName | lastName | country             | street address  | city  | state | zip   | email |
        | thien     | thai     | United States (US) | 44 Spring Creek | Plano | Texas | 75024 | a@gmail.com |
      And I place an order
      Then the order should be places successfully

