Feature: As a user I want to add my first adress (with correct assertions)

  Scenario: The user adds his first adress to MyAccount
    Given   The user is on the homepage
    When    The user logs into his MyAccount
    And     The user submits his first address
    Then    The new address should be show on the address page
