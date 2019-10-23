# language: nl

Functionaliteit: Receive confirmation when adding to cart
  As user of the webshop
  I would like to see a confirmation when I add products to my shopping cart
  So that I know that I added the right product

  Scenario: Add item to shopping cart
    Stel    I am on the Polteq Webshop
    Als     I go to the IPODS page
    En      I go to the iPod Nano detail page
    En      I add the iPod Nano to the cart
    Dan     I get a confirmation that the product is added to the shopping cart
    Maar    I should not be taken directly to my shopping cart

