Feature: The availability of the iPhone4s and accessories should be visible on the search results page

  Scenario: The expected product tags are visible on the homepage
    Given I am on the Polteq Web Shop
    And I search for "Iphone 4S"
    Then I can see the stock availability of the products
    |Product                                                   |Stock                                     |
    |iphone 4s                                                 |Product available with different options  |
    |Shure SE210 Sound-Isolating Earphones for iPod and iPhone |In Stock                                  |
