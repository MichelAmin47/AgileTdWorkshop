Feature: As a user I want to buy a banana

  Scenario: Buy a banana with a credit card
    Given The user is on the homepage
    When I select the fruit section
    Then I should see all the fruit
    When I select a banana in quickview
    And The user selects a banana
    Then The site should see take me to the cart screen
    Given I don't add any more bananas
    When The user buys the banana
    Then I should see a banana purchase receipt

