Feature: Receive confirmation when adding to cart
  As user of the webshop
  I would like to see a confirmation when I add products to my shopping cart
  So that I know that I added the right product

  Scenario: Add item to shopping cart (static)
    Given   I am on the Polteq Webshop
    When    I go to the IPODS page
    And     I go to the iPod Nano detail page
    And     I add the iPod Nano to the cart
    Then    I get a confirmation that the product is added to the shopping cart
    But     I should not be taken directly to my shopping cart

  Scenario: Add multiple items to shopping cart (variable)
    Given I am on the Polteq Webshop
    When I go to the "IPODS" page
    And I go to the "iPod Shuffle" detail page
    And I increase the quantity to 4
    And I add the product to the cart
    Then I get a confirmation that the product is added to the shopping cart
    And the confirmation shows quantity is 4

  Scenario Outline: Add item to shopping cart (outline)
    Given I am on the Polteq Webshop
    When I go to the "<shopPage>" page
    And I go to the <product> detail page
    And I increase the quantity to <amount>
    And I add the product to the cart
    Then I get a confirmation that the product is added to the shopping cart

    Examples:
    |shopPage       |product        |amount|
    |iPods          |"iPod Nano"    |1     |
    |iPods          |"iPod Touch"   |3               |
    |Accessories    |"Belkin Leather Folio for iPod nano - Black..."  |4|












