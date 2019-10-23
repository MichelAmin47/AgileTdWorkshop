Feature: As a user I want to buy a banana and login
  Scenario: Buy a banana and login
    Given The user is on the homepage
    When    The user buys a banana
    Then    The user should be shown a receipt
    Given   The user is on the homepage
    When    The user logs into his MyAccount
    Then    The user should be taken to his Account page

